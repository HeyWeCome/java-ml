package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.employee.EmployeeService;
import com.kang.service.employee.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/28 14:38
 * @version: 1.0
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService = new EmployeeServiceImpl();

    // 员工登录
    @RequestMapping(value = "/login",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String employeeLogin(String account,String password){
        return JSONObject.toJSONString(employeeService.employeeLogin(account,password));
    }

    // 查询所有的员工
    @RequestMapping(value = "/loadAllEmployee",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllEmployee(){
        return JSONObject.toJSONString(employeeService.loadAllEmployee());
    }

}
