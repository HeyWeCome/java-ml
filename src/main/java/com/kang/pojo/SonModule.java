package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 子模块
 * @author: HeyWeCome
 * @createDate: 2020/3/15 14:21
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SonModule {
    String id;                  // 子模块的ID
    String name;                // 子模块的名字
    String status;              // 子模块的状态：0:禁用 1:启用
    String parentModuleID;      // 父亲模块的ID，多对一
}
