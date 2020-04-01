package com.kang.service.school;

import com.kang.pojo.School;

import java.util.List;

public interface SchoolService {
    List<School> loadSchoolByProvincial(String provincialId);       // 根据省份的ID来加载院校信息
}
