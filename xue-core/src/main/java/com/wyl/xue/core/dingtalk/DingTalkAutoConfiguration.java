/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.core.dingtalk;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @ClassName: DingTalkAutoConfiguration
 * @Function: TODO
 * @Date: 2020/5/2 0:01
 * @author wyl
 * @version V1.0
 */
@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(prefix = "dingtalk", name = "enable", havingValue = "true")
@EnableConfigurationProperties(value = DingTalkProperties.class)
@Order(1)
public class DingTalkAutoConfiguration {
    private final DingTalkProperties dingTalkProperties;

    @Bean
    @ConditionalOnProperty(name = "dingtalk.serverUrl")
    DingTalk dingTalk() {
        return new DingTalk(dingTalkProperties.getServerUrl());
    }
}
