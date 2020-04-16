package com.kang.service.subject;

import com.kang.pojo.Subject;

public interface SubjectService {
    Subject getSubjectById(String id);              // 通过题目的ID获取题目信息
}
