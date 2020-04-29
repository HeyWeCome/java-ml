package com.kang.dao.permission;

import com.kang.pojo.Permission;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int addPermission(Permission permission);              // 新增权限
    int deletePermission(@Param("roleId") String roleId,@Param("moduleId") String moduleId);           // 删除权限
}
