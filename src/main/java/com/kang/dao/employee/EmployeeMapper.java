package com.kang.dao.employee;

import com.kang.pojo.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    Employee employeeLogin(@Param("account") String account, @Param("password") String password);         // 员工登录
}
