package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 权限表，仅用于记录角色表和模块的连接
 * @author: HeyWeCome
 * @createDate: 2020/3/15 15:17
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    String id;              // 权限ID
    String roleId;          // 角色ID
    String moduleId;        // 模块ID
}
