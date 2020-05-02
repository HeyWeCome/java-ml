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

    // 修改用户的留言
    @RequestMapping(value = "/modifyDiscussContent",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyDiscussContent(String id, String content){
        return JSONObject.toJSONString(questionDiscussService.modifyDiscussContent(id,content));
    }

    // 删除用户的留言
    @RequestMapping(value = "/deleteQuestionDiscuss",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteQuestionDiscuss(String id){
        return JSONObject.toJSONString(questionDiscussService.deleteQuestionDiscuss(id));
    }

    // 后台加载用户的留言
    @RequestMapping(value = "/loadAllQuestionDiscuss",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllQuestionDiscuss(){
        return JSONObject.toJSONString(questionDiscussService.loadAllQuestionDiscuss());
    }

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

    // 删除用户的留言点赞
    @RequestMapping(value = "/deleteAgree",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteAgree(String id,int agree,String userId){
        return JSONObject.toJSONString(questionDiscussService.deleteAgree(id,agree,userId));
    }

    // 加载题目的收藏数
    @RequestMapping(value = "/loadCollectionCount",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadCollectionCount(String questionId){
        return JSONObject.toJSONString(questionDiscussService.loadCollectionCount(questionId));
    }

    // 检测用户有没有点过赞
    @RequestMapping(value = "/checkUserPrefer",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkUserPrefer(String userId, String questionDiscussId){
        return JSONObject.toJSONString(questionDiscussService.checkUserPrefer(userId,questionDiscussId));
    }
}
