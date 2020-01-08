package com.heywecome.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 部门表
 * @author: HeyWeCome
 * @createDate: 2020/1/8 22:15
 * @version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
