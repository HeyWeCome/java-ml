package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/5 19:44
 * @version: 1.0
 */
@Data
@NoArgsConstructor
public class User {
    private String id;                  // 用户的采用 UUID
    private String name;                // 用户姓名，
    private String account;             // 账号
    private String password;            // 用户密码
    private String email;               // 电子邮箱
    private String phoneNumber;         // 手机号码
    private String address;             // 地址
    private String photo;               // 头像地址
    private String introduction;        // 个人简介
    private int voluntarySchool;        // 报考院校的编号
    private int age;                    // 年龄
    private int sex;                    // 性别，男生 1 ，女生 0

    public void setId(){
        this.id = UUID.randomUUID().toString().replace("-","");
    }
}


