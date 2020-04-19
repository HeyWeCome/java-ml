package com.kang.service.subject;

import com.kang.pojo.Subject;

import java.util.List;

public interface SubjectService {
    Subject getSubjectById(String id);              // 通过题目的ID获取题目信息
    List<Subject> loadAllQuestion();                // 查询全部的问题
}
