/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @ClassName: MyMetaObjectHandler
 * @Function: 自动填充数据
 * @Date: 2020/4/12 16:48
 * @author wyl
 * @version V1.0
 */
@Service
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "creatTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "deleteFlage", Integer.class, 0);
        System.out.println(metaObject);
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
