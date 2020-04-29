package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.role.RoleService;
import com.kang.service.role.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 角色管理类
 * @author: HeyWeCome
 * @createDate: 2020/4/29 22:27
 * @version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService = new RoleServiceImpl();

    // 查询全部的角色
    @RequestMapping(value = "/loadAllRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllRole(){
        return JSONObject.toJSONString(roleService.loadAllRole());
    }

    // 新增角色信息
    @RequestMapping(value = "/addRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addRole(String name, String description){
        return JSONObject.toJSONString(roleService.addRole(name,description));
    }

    // 删除角色信息
    @RequestMapping(value = "/deleteRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteRole(String id){
        return JSONObject.toJSONString(roleService.deleteRole(id));
    }

    // 修改角色信息
    @RequestMapping(value = "/modifyRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyRole(String id, String name, String description){
        return JSONObject.toJSONString(roleService.modifyRole(id,name,description));
    }
}
