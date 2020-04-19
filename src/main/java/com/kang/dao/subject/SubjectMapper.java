package com.kang.dao.subject;

import com.kang.pojo.Subject;

import java.util.List;

public interface SubjectMapper {
    Subject getSubjectById(String id);              // 通过题目的ID获取题目信息
    List<Subject> loadAllQuestion();                // 查询全部的问题
}
