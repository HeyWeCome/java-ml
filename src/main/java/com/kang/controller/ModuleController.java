package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.module.ModuleService;
import com.kang.service.module.ModuleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 21:29
 * @version: 1.0
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
    ModuleService moduleService = new ModuleServiceImpl();

    // 查询全部的模块
    @RequestMapping(value = "/loadAllModule",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllModule(){
        return JSONObject.toJSONString(moduleService.loadAllModule());
    }

    // 新增模块信息
    @RequestMapping(value = "/addModule",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addModule(String name, String status, String description){
        return JSONObject.toJSONString(moduleService.addModule(name,status,description));
    }

    // 修改模块信息
    @RequestMapping(value = "/modifyModule",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyModule(String id, String name, String status, String description){
        return JSONObject.toJSONString(moduleService.modifyModule(id,name,status,description));
    }

    // 删除模块信息
    @RequestMapping(value = "/deleteModule",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteModule(String id){
        return JSONObject.toJSONString(moduleService.deleteModule(id));
    }
}
