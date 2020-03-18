package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/15 14:17
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    String id;      // 模块的ID
    String name;    // 模块的名字
    String status;  // 模块的状态：0:禁用 1:启用
}
