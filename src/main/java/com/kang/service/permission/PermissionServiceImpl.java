package com.kang.service.permission;

import com.kang.dao.employee.EmployeeMapper;
import com.kang.dao.permission.PermissionMapper;
import com.kang.pojo.Permission;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 23:38
 * @version: 1.0
 */
@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    public PermissionMapper getPermissionMapper(){
        return permissionMapper;
    }

    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    // 加载所有的权限
    public List<Permission> loadAllPermission() {
        return permissionMapper.loadAllPermission();
    }

    // 新增权限
    public int addPermission(String roleId, String moduleId) {
        String id = kangkang.id_get();
        Permission permission = new Permission(id,roleId,moduleId);
        return permissionMapper.addPermission(permission);
    }

    // 删除权限
    public int deletePermission(String roleId, String moduleId) {
        return permissionMapper.deletePermission(roleId,moduleId);
    }
}
