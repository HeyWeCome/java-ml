package com.kang.service.employee;


import com.kang.pojo.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
    List<Employee> loadAllEmployee();                                                                       // 加载所有的员工
    List<HashMap> loadAllEmployeeAndRole();                                                                     // 加载所有的员工
    int addEmployee(String name, String sex, String account, String password, String roleId);               // 新增员工
    int modifyEmployee(String id,String name, String sex, String account, String password, String roleId);  // 修改员工
    int deleteEmployee(String id);                                                                          // 删除员工
    Employee employeeLogin(String account, String password);                                                // 员工登录
}
