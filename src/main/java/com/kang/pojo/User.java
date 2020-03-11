package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/5 19:44
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id;                  // 用户的采用 UUID
    String name;                // 用户姓名，
    String account;             // 账号
    String password;            // 用户密码
    String email;               // 电子邮箱
    String phoneNumber;         // 手机号码
    String address;             // 地址
    String photo;               // 头像地址
    String introduction;        // 个人简介
    int voluntarySchool;        // 报考院校的编号
    int age;                    // 年龄
    int sex;                    // 性别，男生 1 ，女生 0
}
