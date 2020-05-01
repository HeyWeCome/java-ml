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

    // 后台管理需要的查询全部投诉
    @RequestMapping(value = "/loadAllReport",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllReport(){
        return JSONObject.toJSONString(discussCorrectionService.loadAllReport());
    }

    // 后台管理根据举报删除留言
    @RequestMapping(value = "/deleteDiscuss",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteDiscuss(String id){
        return JSONObject.toJSONString(discussCorrectionService.deleteDiscuss(id));
    }

    // 后台管理修改举报状态
    @RequestMapping(value = "/modifyReport",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyReport(String id){
        return JSONObject.toJSONString(discussCorrectionService.modifyReport(id));
    }

    // 后台管理删除举报
    @RequestMapping(value = "/deleteReport",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteReport(String id){
        return JSONObject.toJSONString(discussCorrectionService.deleteReport(id));
    }

}
