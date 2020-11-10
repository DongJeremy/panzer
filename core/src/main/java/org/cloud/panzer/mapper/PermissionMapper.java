package org.cloud.panzer.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.cloud.panzer.domain.Permission;

@Mapper
public interface PermissionMapper {

    @Select("SELECT * FROM sys_permission t ORDER BY t.sort")
    List<Permission> listAll();

    @Select("SELECT * FROM sys_permission t WHERE t.type = 1 ORDER BY t.sort")
    List<Permission> listParents();

    @Select("SELECT DISTINCT p.* FROM sys_permission p "
            + "INNER JOIN sys_role_permission rp ON p.id = rp.permission_id "
            + "INNER JOIN sys_role_user ru ON ru.role_id = rp.role_id "
            + "WHERE ru.user_id = #{userId} ORDER BY p.sort")
    List<Permission> listByUserId(Long userId);

    @Select("SELECT p.* FROM sys_permission p "
            + "INNER JOIN sys_role_permission rp ON p.id = rp.permission_id "
            + "WHERE rp.role_id = #{roleId} ORDER BY p.sort")
    List<Permission> listByRoleId(Long roleId);

    @Select("SELECT * FROM sys_permission t WHERE t.id = #{id}")
    Permission getById(Long id);

    @Delete("DELETE FROM sys_role_permission WHERE permission_id = #{permissionId}")
    int deleteRolePermission(Long permissionId);

    @Delete("DELETE FROM sys_permission WHERE parent_id = #{id}")
    int deleteByParentId(Long id);

    @Select("SELECT ru.userId FROM sys_role_permission rp "
            + "INNER JOIN sys_role_user ru on ru.role_id = rp.role_id "
            + "WHERE rp.permission_id = #{permissionId}")
    Set<Long> listUserIds(Long permissionId);

    @Delete("DELETE FROM sys_permission WHERE id = #{id}")
    int delete(Long id);

    @Update("UPDATE sys_permission t "
            + "SET parent_id = #{parentId}, name = #{name}, css = #{css}, href = #{href}, type = #{type}, "
            + "permission = #{permission}, sort = #{sort} WHERE t.id = #{id}")
    int update(Permission permission);

    @Insert("INSERT INTO sys_permission(parent_id, name, css, href, type, permission, sort) "
            + "values(#{parentId}, #{name}, #{css}, #{href}, #{type}, #{permission}, #{sort})")
    int save(Permission permission);

}
