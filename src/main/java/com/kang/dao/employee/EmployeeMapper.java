package com.kang.dao.employee;

import com.kang.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> loadAllEmployee();                                                                     // 加载所有的员工
    List<HashMap> loadAllEmployeeAndRole();                                                               // 加载所有的员工联想角色
    int addEmployee(Employee employee);                                                                   // 新增员工
    int modifyEmployee(Employee employee);                                                               // 修改员工
    int deleteEmployee(String id);                                                                          // 删除员工
    Employee employeeLogin(@Param("account") String account, @Param("password") String password);         // 员工登录
}
