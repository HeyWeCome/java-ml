package com.kang.service.school;

import com.kang.dao.school.SchoolMapper;
import com.kang.pojo.School;
import com.kang.utils.kangkang;
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

    // 加载所有的院校
    public List<School> loadAllSchool() {
        return schoolMapper.loadAllSchool();
    }

    public List<School> loadAllSchoolAndProvincial() {
        return schoolMapper.loadAllSchoolAndProvincial();
    }

    // 新增院校信息
    public int addSchool(String name, String provincial, String location,String photo, String introduction, String postCode) {
        String id = kangkang.id_get();
        String heat = "0";
        School school = new School(id,name,provincial,location,photo,introduction,heat,postCode);

        int result = schoolMapper.addSchool(school);
        return result;
    }

    // 修改学校信息
    public int modifySchool(String id, String name, String provincial, String location, String introduction, String postCode) {
        School school = new School();
        school.setId(id);
        school.setName(name);
        school.setProvincial(provincial);
        school.setLocation(location);
        school.setIntroduction(introduction);
        school.setPostcode(postCode);
        return schoolMapper.modifySchool(school);
    }

    // 删除院校信息
    public int deleteSchool(String id) {
        return schoolMapper.deleteSchool(id);
    }

    // 根据省份ID查询出院校
    public List<School> loadSchoolByProvincial(String provincialId) {
        return schoolMapper.loadSchoolByProvincial(provincialId);
    }

    // 根据院校名称来模糊搜索院校信息
    public List<School> searchSchool(String schoolName) {
        return schoolMapper.searchSchool(schoolName);
    }

    // 通过院校ID来查询学校的信息
    public School searchSchoolById(String schoolId) {
        return schoolMapper.searchSchoolById(schoolId);
    }
}
