package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 学校类
 * @author: HeyWeCome
 * @createDate: 2020/3/11 20:31
 * @version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    String id;              // 编号
    String name;            // 学校名
    int provincial;         // 所属省份编号
    String location;        // 地理位置
    String photo;           // 校徽地址
    String introduction;    // 学校介绍
    int heat;               // 学校热度
    String postcode;        // 邮编
}
