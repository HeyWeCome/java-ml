package com.kang.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kang.service.question.QuestionService;
import com.kang.service.question.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/3 10:01
 * @version: 1.0
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService = new QuestionServiceImpl();

    @RequestMapping(value = "/loadQuestionBySchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadQuestionBySchool(String schoolId){
        System.out.println("QuestionController加载院校ID:"+schoolId);
        return JSONObject.toJSONString(questionService.loadQuestionBySchool(schoolId));
    }
}
