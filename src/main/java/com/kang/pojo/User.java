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
    String userName;              // 用户id，采用 UUID
    String password;            // 用户姓名
}
