package com.kang.pojo;

import com.kang.utils.kangkang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    private String voluntarySchool;     // 报考院校的编号
    private String birthday;            // 出生年月
    private String sex;                 // 性别，男生 1 ，女生 0
    private String createTime;          // 用户创建的日期

    public void setId(){
        this.id = UUID.randomUUID().toString().replace("-","");
    }

    public void setCreateTime(){
        this.createTime = kangkang.time_get();
    }
}


