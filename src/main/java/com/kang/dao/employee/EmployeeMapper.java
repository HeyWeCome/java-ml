package com.kang.dao.employee;

import com.kang.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> loadAllEmployee();                                                                     // 加载所有的员工
    Employee employeeLogin(@Param("account") String account, @Param("password") String password);         // 员工登录
}
