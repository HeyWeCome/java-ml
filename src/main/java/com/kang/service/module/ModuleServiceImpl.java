package com.kang.service.module;

import com.kang.dao.error.ErrorMapper;
import com.kang.dao.module.ModuleMapper;
import com.kang.pojo.Module;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 21:30
 * @version: 1.0
 */
@Service("ModuleServiceImpl")
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;

    public ModuleMapper getModuleMapper(){
        return moduleMapper;
    }

    public void setModuleMapper(ModuleMapper moduleMapper) {
        this.moduleMapper = moduleMapper;
    }

    public List<Module> loadAllModule() {
        List<Module> modules = moduleMapper.loadAllModule();

        for (Module module : modules) {
            if(module.getStatus().equals("1")){
                module.setStatus("启用");
            }else {
                module.setStatus("禁用");
            }
        }
        return modules;
    }

    // 新增模块信息
    public int addModule(String name, String status, String description) {
        String id = kangkang.id_get();      // 获取一个id
        Module module = new Module(id,name,status,description);
        return moduleMapper.addModule(module);
    }

    // 修改模块信息
    public int modifyModule(String id, String name, String status, String description) {
        Module module = new Module(id,name,status,description);
        return moduleMapper.modifyModule(module);
    }

    // 删除模块
    public int deleteModule(String id) {
        return moduleMapper.deleteModule(id);
    }
}
