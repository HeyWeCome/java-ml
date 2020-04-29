package com.kang.service.module;

import com.kang.pojo.Module;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 21:30
 * @version: 1.0
 */
public interface ModuleService {
    List<Module> loadAllModule();                                       // 查询所有的模块的信息
    int addModule(String name, String status, String description);      // 新增模块
    int modifyModule(String id,String name, String status, String description);   // 修改模块
    int deleteModule(String id);                                        // 删除模块
}
