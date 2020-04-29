package com.kang.service.role;

import com.kang.dao.role.RoleMapper;
import com.kang.pojo.Role;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 22:29
 * @version: 1.0
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public RoleMapper getRoleMapper(){
        return this.roleMapper;
    }

    public void setRoleMapper(){
        this.roleMapper = roleMapper;
    }

    public List<Role> loadAllRole() {
        return roleMapper.loadAllRole();
    }

    // 新增角色
    public int addRole(String name, String description) {
        String id = kangkang.id_get();
        Role role = new Role(id,name,description);
        return roleMapper.addRole(role);
    }

    public int modifyRole(String id, String name, String description) {
        Role role = new Role(id,name,description);
        return roleMapper.modifyRole(role);
    }

    // 删除角色
    public int deleteRole(String id) {
        return roleMapper.deleteRole(id);
    }
}
