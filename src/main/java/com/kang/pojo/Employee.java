package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 员工类
 * @author: HeyWeCome
 * @createDate: 2020/3/15 14:14
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    String id;          // 员工的ID
    String name;        // 员工的名字
    int sex;            // 员工的性别：1是男 0是女
    String account;     // 员工的账号
    String password;    // 员工的密码
    String roleId;      // 角色ID
}
