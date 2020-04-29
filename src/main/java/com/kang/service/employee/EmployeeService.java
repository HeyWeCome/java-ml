package com.kang.service.employee;


import com.kang.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> loadAllEmployee();                                // 加载所有的员工
    Employee employeeLogin(String account, String password);         // 员工登录
}
