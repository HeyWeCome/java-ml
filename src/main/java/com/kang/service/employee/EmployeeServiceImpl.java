package com.kang.service.employee;

import com.kang.dao.discussCorrection.DiscussCorrectionMapper;
import com.kang.dao.employee.EmployeeMapper;
import com.kang.pojo.Employee;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    public List<HashMap> loadAllEmployeeAndRole() {
        return employeeMapper.loadAllEmployeeAndRole();
    }

    // 新增员工
    public int addEmployee(String name, String sex, String account, String password, String roleId) {
        String id = kangkang.id_get();
        Employee employee = new Employee(id,name,sex,account,password,roleId);
        return employeeMapper.addEmployee(employee);
    }

    // 修改员工
    public int modifyEmployee(String id, String name, String sex, String account, String password, String roleId) {
        Employee employee = new Employee(id,name,sex,account,password,roleId);
        return employeeMapper.modifyEmployee(employee);
    }

    public int deleteEmployee(String id) {
        return employeeMapper.deleteEmployee(id);
    }

    // 用户登录
    public Employee employeeLogin(String account, String password) {
        return employeeMapper.employeeLogin(account,password);
    }
}
