package com.kang.service.employee;

import com.kang.dao.discussCorrection.DiscussCorrectionMapper;
import com.kang.dao.employee.EmployeeMapper;
import com.kang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/28 14:48
 * @version: 1.0
 */
@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeMapper getEmployeeMapper(){
        return employeeMapper;
    }

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    // 加载所有的员工
    public List<Employee> loadAllEmployee() {
        return employeeMapper.loadAllEmployee();
    }

    // 用户登录
    public Employee employeeLogin(String account, String password) {
        return employeeMapper.employeeLogin(account,password);
    }
}
