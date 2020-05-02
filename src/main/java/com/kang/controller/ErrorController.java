package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.error.ErrorService;
import com.kang.service.error.ErrorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 纠错类
 * @author: HeyWeCome
 * @createDate: 2020/4/23 14:50
 * @version: 1.0
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @Autowired
    ErrorService errorService = new ErrorServiceImpl();

    // 加载全部题目错误信息
    @RequestMapping(value = "/loadAllError",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllError(){
        return JSONObject.toJSONString(errorService.loadAllError());
    }

    // 后台加载全部题目错误信息
    @RequestMapping(value = "/loadError",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadError(){
        return JSONObject.toJSONString(errorService.loadError());
    }

    // 后台修改题目的状态
    @RequestMapping(value = "/modifyStatus",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyStatus(String id,String status){
        return JSONObject.toJSONString(errorService.modifyStatus(id,status));
    }

    // 后台删除题目的纠错
    @RequestMapping(value = "/delete",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String delete(String id){
        return JSONObject.toJSONString(errorService.delete(id));
    }

    @RequestMapping(value = "/addError",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addError(String questionId,String reporteId,String reason){
        return JSONObject.toJSONString(errorService.addError(questionId,reporteId,reason));
    }
}
