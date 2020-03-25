package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户发布的动态
 * @author: HeyWeCome
 * @createDate: 2020/3/25 21:06
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDiary {
    String id;              // 动态的ID
    String userId;          // 用户的ID
    String content;         // 用户发布的内容
    String createTime;      // 创建的时间
}
