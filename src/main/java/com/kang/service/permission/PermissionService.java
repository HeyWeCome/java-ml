package com.kang.service.permission;

import com.kang.pojo.Permission;

public interface PermissionService {
    int addPermission(String roleId, String moduleId);              // 新增权限
    int deletePermission(String roleId, String moduleId);           // 删除权限
}
