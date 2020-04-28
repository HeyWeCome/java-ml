package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.discussCorrection.DiscussCorrectionService;
import com.kang.service.discussCorrection.DiscussCorrectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/25 20:27
 * @version: 1.0
 */
@Controller
@RequestMapping("/discussCorrect")
public class DisscussCorrectionController {
    @Autowired
    DiscussCorrectionService discussCorrectionService = new DiscussCorrectionServiceImpl();

    // 查询全部的投诉
    @RequestMapping(value = "/loadAllCorrect",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllCorrect(){
        return JSONObject.toJSONString(discussCorrectionService.loadAllCorrect());
    }

    // 用户新增投诉
    @RequestMapping(value = "/addDisscussCorrection",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addDisscussCorrection(String discussId,String reporterId,String content){
        return JSONObject.toJSONString(discussCorrectionService.addDiscussCorrection(discussId,reporterId,content));
    }
}
