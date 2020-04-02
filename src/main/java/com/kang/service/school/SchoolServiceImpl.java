package com.kang.service.school;

import com.kang.dao.school.SchoolMapper;
import com.kang.pojo.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/1 23:13
 * @version: 1.0
 */
@Service("SchoolServiceImpl")
public class SchoolServiceImpl implements SchoolService {
    // service调用dao层
    @Autowired
    private SchoolMapper schoolMapper;

    public SchoolMapper getSchoolMapper(){
        return schoolMapper;
    }

    public void setSchoolMapper(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    // 根据省份ID查询出院校
    public List<School> loadSchoolByProvincial(String provincialId) {
        return schoolMapper.loadSchoolByProvincial(provincialId);
    }

    // 根据院校名称来模糊搜索院校信息
    public List<School> searchSchool(String schoolName) {
        return schoolMapper.searchSchool(schoolName);
    }
}
