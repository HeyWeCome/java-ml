package com.kang.dao.school;

import com.kang.pojo.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 院校信息的展示
public interface SchoolMapper {
    List<School> loadSchoolByProvincial(String provincialId);       // 根据省份的ID来加载院校信息
    List<School> searchSchool(@Param("schoolName") String schoolName);                   // 根据院校名称来模糊搜索院校信息
}
