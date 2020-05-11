/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.core.dingtalk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DingTalkProperties
 * @Function: TODO
 * @Date: 2020/5/1 23:58
 * @author wyl
 * @version V1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "dingtalk")
public class DingTalkProperties {
    private String serverUrl;
}
