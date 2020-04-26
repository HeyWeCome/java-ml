package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 初始真题套卷，其实也就是学校和考试专业代码的关联表
 * @author: HeyWeCome
 * @createDate: 2020/4/3 9:36
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPaper {
    private String id;              // 套卷的ID
    private String codeId;          // 专业代码
    private String year;            // 年份
    private String schoolId;        // 出题院校ID
    private String heat;            // 热度
    private String download;        // 存储的地址
}
