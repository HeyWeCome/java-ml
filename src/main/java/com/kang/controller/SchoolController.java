package com.kang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kang.service.school.SchoolService;
import com.kang.service.school.SchoolServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

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

    // 加载所有的学校以及他们的省份信息
    @RequestMapping(value = "/loadAllSchoolAndProvincial",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllSchoolAndProvincial(){
        return JSON.toJSONString(schoolService.loadAllSchoolAndProvincial());
    }

    // 新增院校信息
    @RequestMapping(value = "/addSchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addSchool(String name, String provincial,String location,String introduction, String postCode) throws Exception{
        String photo = "";
        return JSON.toJSONString(schoolService.addSchool(name,provincial,location,photo,introduction,postCode));
    }

    // 修改院校信息
    @RequestMapping(value = "/modifySchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifySchool(String id,String name, String provincial,String location,String introduction, String postCode) throws Exception{
        return JSON.toJSONString(schoolService.modifySchool(id,name,provincial,location,introduction,postCode));
    }

    // 删除院校信息
    @RequestMapping(value = "/deleteSchool",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteSchool(String id) throws Exception{
        return JSON.toJSONString(schoolService.deleteSchool(id));
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
