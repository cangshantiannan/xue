package com.wyl.xue.core.redis;

import lombok.Data;

/**
 * @ClassName: LettuceSentinelProperties
 * @Function: 哨兵模式配置
 * @Date: 2020/4/23 23:20
 * @author wangyl
 * @version V1.0
 */
@Data
public class LettuceSentinelProperties extends LettuceSingleProperties {

    private String masterId;
}
