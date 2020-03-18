package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户做的笔记
 * @author: HeyWeCome
 * @createDate: 2020/3/17 10:39
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class userNote {
    String id;          // 用户做的笔记的ID
    String questionId;  // 试题的ID
    String userId;      // 用户的ID
    String content;     // 笔记的内容
    String notebookId;  // 笔记本的ID
    String time;        // 创建时间
}
