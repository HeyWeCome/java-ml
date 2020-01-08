package com.heywecome.dao;

import com.heywecome.pojo.Department;
import com.heywecome.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 员工dao
 * @author: HeyWeCome
 * @createDate: 2020/1/8 22:44
 * @version: 1.0
 */
@Repository
public class EmployeeDao {
    // 模拟数据库数据
    private static Map<Integer, Employee> employees = null;
    // 员工有所属的部门\
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer,Employee>(); // 创建一个部门表

        employees.put(101,new Employee(1001,"AA","A2432311@qq.com",1,new Department(101,"教学部")));
        employees.put(102,new Employee(1002,"BB","B2432311@qq.com",0,new Department(102,"市场部")));
        employees.put(103,new Employee(1003,"CC","C2432311@qq.com",1,new Department(103,"教研部")));
        employees.put(104,new Employee(1004,"DD","D2432311@qq.com",0,new Department(104,"运营部")));
        employees.put(105,new Employee(1005,"EE","E2432311@qq.com",1,new Department(105,"后勤部")));
    }
    // 主键自增
    private static Integer initId = 1006;
    // 新增员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过ID查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
