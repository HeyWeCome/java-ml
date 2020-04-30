package com.kang.dao.permission;

import com.kang.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    List<Permission> loadAllPermission();                   // 加载所有的权限
    int addPermission(Permission permission);              // 新增权限
    int deletePermission(@Param("roleId") String roleId,@Param("moduleId") String moduleId);           // 删除权限
}
