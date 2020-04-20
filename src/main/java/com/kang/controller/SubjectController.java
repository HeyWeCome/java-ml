package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.subject.SubjectService;
import com.kang.service.subject.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/20 21:21
 * @version: 1.0
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService = new SubjectServiceImpl();

    @RequestMapping(value = "/getSubjectById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getSubjectById(String subjectId){
        return JSONObject.toJSONString(subjectService.getSubjectById(subjectId));
    }
}
