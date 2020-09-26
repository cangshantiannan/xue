/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.admin.system.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyl.xue.admin.system.mybatis.entity.SystemRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SystemRoleMenuMapper
 * @Function: 角色和菜单关联信息Mapper
 * @Date: 2019/12/18 0:45
 * @author wangyl
 * @version V1.0
 */
public interface SystemRoleMenuMapper extends BaseMapper<SystemRoleMenu> {
    /**
     * @Description 通过角色ID获取角色权限
     * @param rolesId
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.String>>
     * @Date 2020/5/22 10:58
     * @Author wangyl
     * @Version V1.0
     */
    @Select({"<script>", "SELECT perms FROM system_role_menu AS a LEFT JOIN system_menu AS b ON a.menu_id=b.menu_id WHERE b.perms is not null AND a.role_id IN", "<foreach collection='rolesId' item='roleId' open='(' separator=',' close=')'>", "#{roleId}", "</foreach>", "</script>"})
    List<Map<String, String>> getPermByRolesId(@Param("rolesId") List<Long> rolesId);

    @Select({"<script>", "SELECT a.menu_id AS menu_id FROM system_role_menu AS a LEFT JOIN system_menu AS b ON a.menu_id=b.menu_id WHERE b.type in (0,1) AND a.role_id IN", "<foreach collection='rolesId' item='roleId' open='(' separator=',' close=')'>", "#{roleId}", "</foreach>", "</script>"})
    List<Map<String, Long>> getMenusByRolesId(@Param("rolesId") List<Long> rolesId);
}
