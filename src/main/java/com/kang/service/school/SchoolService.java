package com.kang.service.school;

import com.kang.pojo.School;

import java.util.List;

public interface SchoolService {
    List<School> loadAllSchool();                                   // 加载所有院校信息
    List<School> loadAllSchoolAndProvincial();                      // 加载所有院校信息以及省份信息
    int addSchool(String name, String provincial,String location,String photo,String introduction, String postCode);                                       // 新增院校
    int modifySchool(String id,String name,String provincial,String location,String introduction,String postCode);
    int deleteSchool(String id);                                        // 删除院校
    List<School> loadSchoolByProvincial(String provincialId);       // 根据省份的ID来加载院校信息
    List<School> searchSchool(String schoolName);                   // 根据院校名称来模糊搜索院校信息
    School searchSchoolById(String schoolId);                       // 通过院校ID来查询学校的信息
}
