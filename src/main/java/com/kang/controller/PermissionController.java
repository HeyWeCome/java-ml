package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.permission.PermissionService;
import com.kang.service.permission.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 权限类
 * @author: HeyWeCome
 * @createDate: 2020/4/29 23:31
 * @version: 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService = new PermissionServiceImpl();

    // 纠错题目信息
    @RequestMapping(value = "/addPermission",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addPermission(String roleId, String moduleId){
        return JSONObject.toJSONString(permissionService.addPermission(roleId,moduleId));
    }

    // 纠错题目信息
    @RequestMapping(value = "/deletePermission",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deletePermission(String roleId, String moduleId){
        return JSONObject.toJSONString(permissionService.deletePermission(roleId,moduleId));
    }
}
