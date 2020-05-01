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

    // 加载所有的员工
    @RequestMapping(value = "/loadAllEmployeeAndRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllEmployeeAndRole(){
        return JSONObject.toJSONString(employeeService.loadAllEmployeeAndRole());
    }

    // 新增的员工
    @RequestMapping(value = "/addEmployee",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addEmployee(String name,String account,String password,String sex, String role){
        return JSONObject.toJSONString(employeeService.addEmployee(name,sex,account,password,role));
    }

    // 修改员工
    @RequestMapping(value = "/modifyEmployee",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyEmployee(String id,String name,String account,String password,String sex, String role){
        return JSONObject.toJSONString(employeeService.modifyEmployee(id,name,sex,account,password,role));
    }

    // 删除员工
    @RequestMapping(value = "/deleteEmployee",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteEmployee(String id){
        return JSONObject.toJSONString(employeeService.deleteEmployee(id));
    }

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
