package com.kang.wecode.dao;


import com.kang.wecode.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/2/28 20:24
 * @version: 1.0
 */
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
