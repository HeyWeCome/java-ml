package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.questionDiscuss.QuestionDiscussService;
import com.kang.service.questionDiscuss.QuestionDiscussServiceImpl;
import com.kang.service.subject.SubjectService;
import com.kang.service.subject.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 用户留言模块
 * @author: HeyWeCome
 * @createDate: 2020/4/23 15:35
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/questionDiscuss",produces = "application/json; charset=utf-8")
public class QuestionDiscussController {
    @Autowired
    private QuestionDiscussService questionDiscussService = new QuestionDiscussServiceImpl();

    // 新增用户留言问题
    @RequestMapping(value = "/addQuestionDiscuss",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addQuestionDiscuss(String questionId, String userId, String content, String parent){
        return JSONObject.toJSONString(questionDiscussService.addQuestionDiscuss(questionId,userId,content,parent));
    }

    // 加载用户的留言
    @RequestMapping(value = "/loadQuestionDiscuss",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadQuestionDiscuss(String questionId){
        return JSONObject.toJSONString(questionDiscussService.loadQuestionDiscuss(questionId));
    }

    // 加载用户的留言点赞
    @RequestMapping(value = "/addAgree",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addAgree(String id,int agree,String userId){
        return JSONObject.toJSONString(questionDiscussService.addAgree(id,agree,userId));
    }
}
