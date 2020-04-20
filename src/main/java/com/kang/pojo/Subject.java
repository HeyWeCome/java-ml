package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 具体的题目
 * @author: HeyWeCome
 * @createDate: 2020/4/16 15:55
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    String id;              // 题目的ID
    String title;           // 题目的标题
    String classify;        // 题目的具体分类：1.数据结构 2.计网 3.机组 4.操作系统
    String type;            // 题目的类型：1.单选 2.问答，暂时只考虑这两种
    String optionA;         // 选项 A
    String optionB;         // 选项 B
    String optionC;         // 选项 C
    String optionD;         // 选项 D
    String content;         // 问答题的内容
    Integer heat;            // 热度
}
