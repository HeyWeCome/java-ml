package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户的赞同和不赞同
 * @author: HeyWeCome
 * @createDate: 2020/3/17 10:18
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrefer {
    String id;                      // 记录的ID
    String userId;                  // 用户的ID
    String questionDiscussId;      // 试题讨论的ID 父级子级都可以点赞
}
