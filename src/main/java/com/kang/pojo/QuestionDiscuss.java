package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 试题讨论区
 * @author: HeyWeCome
 * @createDate: 2020/3/17 10:07
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDiscuss {
    String id;              // 主键ID
    String questionId;      // 试题的ID
    String userId;          // 用户的ID
    String content;         // 用户讨论的内容
    String parent;          // 一级回复：0，子集回复则为父ID
    String time;            // 创建的时间
    Integer agree;           // 赞同数
    Integer disagree;       // 不赞同数
}
