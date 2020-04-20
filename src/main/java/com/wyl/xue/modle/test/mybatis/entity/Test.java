package com.wyl.xue.modle.test.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wyl.xue.system.mybatis.entity.SystemBase;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: Test
 * @Function: TODO
 * @Date: 2020/4/19 23:42
 * @author wyl
 * @version V1.0
 */
@Data
@Builder
@TableName(value = "test")
public class Test extends SystemBase {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
}
