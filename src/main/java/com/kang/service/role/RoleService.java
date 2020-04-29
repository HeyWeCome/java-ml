package com.kang.service.role;

import com.kang.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> loadAllRole();                                   // 查询所有的角色
    int addRole(String name, String description);               // 新增角色
    int modifyRole(String id, String name, String descritption); // 修改角色
    int deleteRole(String id);                                  // 删除角色
}
