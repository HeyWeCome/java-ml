package com.kang.dao.module;

import com.kang.pojo.Module;

import java.util.List;

public interface ModuleMapper {
    List<Module> loadAllModule();               // 查询所有的模块的信息
    int addModule(Module module);               // 新增模块信息
    int modifyModule(Module module);            // 修改模块信息
    int deleteModule(String id);                // 删除模块
}
