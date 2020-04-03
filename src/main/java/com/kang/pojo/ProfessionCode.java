package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 专业代码
 * @author: HeyWeCome
 * @createDate: 2020/4/3 9:39
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionCode {
        String id;              // 专属ID
        String codeId;          // 专业代码
        String name;            // 考试内容名称
        String description;     // 专业代码所表示的学科的内容描述
}
