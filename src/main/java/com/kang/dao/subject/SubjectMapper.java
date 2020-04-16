package com.kang.dao.subject;

import com.kang.pojo.Subject;

public interface SubjectMapper {
    Subject getSubjectById(String id);              // 通过题目的ID获取题目信息
}
