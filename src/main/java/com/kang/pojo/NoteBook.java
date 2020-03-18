package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户的笔记本
 * @author: HeyWeCome
 * @createDate: 2020/3/17 10:35
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteBook {
    String id;      // 笔记本的ID
    String userId;  // 用户的ID
    String name;    // 笔记本的名字
    String time;    // 创建的时间
}
