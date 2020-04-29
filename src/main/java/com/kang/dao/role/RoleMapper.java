package com.kang.dao.role;

import com.kang.pojo.Role;

import java.util.List;

// 角色管理
public interface RoleMapper {
    List<Role> loadAllRole();             // 查询所有的角色
    int addRole(Role role);               // 新增角色
    int modifyRole(Role role);            // 修改角色
    int deleteRole(String id);            // 删除角色
}
