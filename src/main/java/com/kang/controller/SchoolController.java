package com.kang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kang.service.school.SchoolService;
import com.kang.service.school.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 院校部分的Controller·
 * @author: HeyWeCome
 * @createDate: 2020/4/1 16:59
 * @version: 1.0
 */
@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService = new SchoolServiceImpl();

    // 加载所有的学校
    @RequestMapping(value = "/loadAllSchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllSchool(){
        return JSON.toJSONString(schoolService.loadAllSchool());
    }

    // 根据省份ID加载所有的院校信息
    @RequestMapping(value = "/loadSchoolByProvincial",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadSchool(String provincialId){
        return JSON.toJSONString(schoolService.loadSchoolByProvincial(provincialId));
    }

    // 模糊搜索院校信息
    @RequestMapping(value = "/searchSchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchSchool(String keyword){

        String schoolName = "%"+keyword+"%";
        return JSONObject.toJSONString(schoolService.searchSchool(schoolName));
    }

    // 通过ID查询院校信息
    @RequestMapping(value = "/searchSchoolById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchSchoolById(String schoolId){
        return JSONObject.toJSONString(schoolService.searchSchoolById(schoolId));
    }
}
