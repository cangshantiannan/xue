/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.security.conf;

import com.wyl.xue.security.filter.JwtAuthenticationTokenFilter;
import com.wyl.xue.security.handle.AuthenticationEntryPointImpl;
import com.wyl.xue.security.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ClassName: WebSercurityConfig
 * @Function: TODO
 * @Date: 2019/12/16 0:27
 * @author wyl
 * @version V1.0
 */
@Configuration
@EnableWebSecurity
/**
 *开启注解功能
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *未登录用户
     */
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;
    /**
     * 用户登录验证器
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * jwt信息过滤器
     */
    @Autowired
    private JwtAuthenticationTokenFilter JwtAuthenticationTokenFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                // 短信登录配置
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 过滤请求
                .authorizeRequests()
                // 对于登录login 图标 要允许匿名访问
                .antMatchers("/v1/login/**").anonymous().antMatchers(HttpMethod.POST, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/*.css").permitAll().antMatchers("/captcha.jpg").anonymous().antMatchers("/sendCode/**").anonymous().antMatchers("/tenant/list").anonymous().antMatchers("/tenant/setting/**").anonymous().antMatchers("/define/deploy/**").anonymous().antMatchers("/define/viewProcessImage/**").permitAll()
                .antMatchers("/swagger-resources/**","/swagger-ui.html","/webjars/**","/swagger/**","/v2/**","/csrf").anonymous()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated().and().headers().frameOptions().disable();
        httpSecurity
                // 添加JWT验证过滤器
                .addFilterBefore(JwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                /**
                 *设置用户登录验证
                 */.userDetailsService(userDetailsService)
                /**
                 *使用密码加密策略
                 */.passwordEncoder(passwordEncoder());
    }


    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * @Description 密码加密对象
     * @param
     * @return org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
     * @Date 2019/12/22 17:48
     * @Author wangyl
     * @Version V1.0
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
