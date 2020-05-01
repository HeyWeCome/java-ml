package com.kang.dao.school;

import com.kang.pojo.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 院校信息的展示
public interface SchoolMapper {
    List<School> loadAllSchool();                                       // 加载所有院校信息
    List<School> loadAllSchoolAndProvincial();                          // 加载所有院校信息以及省份信息
    int addSchool(School school);                                       // 新增院校
    int modifySchool(School school);                                    // 修改院校
    int deleteSchool(String id);                                        // 删除院校
    List<School> loadSchoolByProvincial(String provincialId);           // 根据省份的ID来加载院校信息
    List<School> searchSchool(@Param("schoolName") String schoolName);  // 根据院校名称来模糊搜索院校信息
    School searchSchoolById(String schoolId);                           // 通过院校ID来查询学校的信息
}
