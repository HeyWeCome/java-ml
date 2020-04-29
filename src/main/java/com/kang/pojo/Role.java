package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 角色类
 * @author: HeyWeCome
 * @createDate: 2020/4/29 22:33
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    String id;          // 角色的ID
    String name;        // 角色的名称
    String description; // 角色的描述
}
