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

    // 用户添加笔记
    @RequestMapping(value = "/addNote",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addNote(String subjectId,String content, String userId){
        // 返回1 添加成功
        return JSONObject.toJSONString(subjectService.addNote(subjectId,content,userId));
    }

    // 用户修改笔记
    @RequestMapping(value = "/modifyNote",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyNote(String id,String content){
        // 返回1 添加成功
        return JSONObject.toJSONString(subjectService.modifyNote(id,content));
    }

    // 加载用户的笔记
    @RequestMapping(value = "/loadNoteById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadNoteById(String subjectId,String userId){
        // 返回1 添加成功
        return JSONObject.toJSONString(subjectService.loadNoteById(subjectId,userId));
    }

    // 检测用户的笔记是否存在
    @RequestMapping(value = "/checkNoteById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkNoteById(String subjectId,String userId){
        return JSONObject.toJSONString(subjectService.checkUserNoteExist(subjectId,userId));
    }
}
