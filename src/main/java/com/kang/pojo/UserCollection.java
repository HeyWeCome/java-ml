package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户收藏表
 * @author: HeyWeCome
 * @createDate: 2020/3/17 10:16
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCollection {
    String id;              // 收藏的ID
    String userId;          // 用户的ID
    String questionId;      // 试题的ID
}
