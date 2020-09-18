/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.core.conf;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomIdGenerator
 * @Function: 主键ID生成器 雪花
 * @Date: 2020/4/8 22:54
 * @author wyl
 * @version V1.0
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    /**
     * 生成Id
     *
     * @param entity 实体
     * @return id
     */
    @Override
    public Number nextId(Object entity) {
        return IdUtil.createSnowflake(1, 1)
                     .nextId();
    }

    /**
     * 生成uuid
     *
     * @param entity 实体
     * @return uuid
     */
    @Override
    public String nextUUID(Object entity) {
        return IdUtil.createSnowflake(1, 1)
                     .nextIdStr();
    }
}
