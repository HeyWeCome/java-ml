package com.kang.service.permission;

import com.kang.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> loadAllPermission();                           // 加载所有的权限
    int addPermission(String roleId, String moduleId);              // 新增权限
    int deletePermission(String roleId, String moduleId);           // 删除权限
}
