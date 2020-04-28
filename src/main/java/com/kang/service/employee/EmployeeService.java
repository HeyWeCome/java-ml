package com.kang.service.employee;


import com.kang.pojo.Employee;

public interface EmployeeService {
    Employee employeeLogin(String account, String password);         // 员工登录
}
