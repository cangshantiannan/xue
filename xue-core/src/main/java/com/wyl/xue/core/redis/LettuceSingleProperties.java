package com.wyl.xue.core.redis;

import lombok.Data;

/**
 * @ClassName: LettuceSingleProperties
 * @Function: 单机模式配置
 * @Date: 2020/4/23 23:18
 * @author wangyl
 * @version V1.0
 */
@Data
public class LettuceSingleProperties {
    private String host;
    private Integer port;
    private String password;
}
