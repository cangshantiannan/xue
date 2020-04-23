package com.wyl.xue.test.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: RestTemplateConfig
 * @Function: RestTemplate 配置文件
 * @Date: 2020/3/13 11:18
 * @author wangyl
 * @version V1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    /**
     * @Description RestTemplate 配置为okhttp3
     * @param
     * @return org.springframework.http.client.ClientHttpRequestFactory
     * @Date 2020/3/13 11:18
     * @Author wangyl
     * @Version V1.0
     */
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        factory.setConnectTimeout(12000);
        factory.setReadTimeout(12000);
        return factory;
    }

}
