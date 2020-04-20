package com.kang.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.Subject;
import com.kang.service.question.QuestionService;
import com.kang.service.question.QuestionServiceImpl;
import com.kang.service.subject.SubjectService;
import com.kang.service.subject.SubjectServiceImpl;
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
    @Autowired
    private SubjectService subjectService = new SubjectServiceImpl();

    @RequestMapping(value = "/loadQuestionBySchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadQuestionBySchool(String schoolId){
        return JSONObject.toJSONString(questionService.loadQuestionBySchool(schoolId));
    }

    // 加载所有的题目
    @RequestMapping(value = "/loadAllQuestion",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllQuestion(){
        return JSONObject.toJSONString(subjectService.loadAllQuestion());
    }

    // 根据类型筛选题目
    @RequestMapping(value = "/loadQuestionByClassify",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadQuestionByClassify(String classify){
        return JSONObject.toJSONString(subjectService.loadQuestionByClassify(classify));
    }

}
