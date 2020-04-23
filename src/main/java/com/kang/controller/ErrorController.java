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

    @RequestMapping(value = "/addError",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addError(String questionId,String reporteId,String reason){
        return JSONObject.toJSONString(errorService.addError(questionId,reporteId,reason));
    }
}
