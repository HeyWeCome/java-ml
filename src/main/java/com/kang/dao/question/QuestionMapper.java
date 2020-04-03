package com.kang.dao.question;

import java.util.HashMap;
import java.util.List;

public interface QuestionMapper {
    List<HashMap> loadQuestionBySchool(String schoolId);        // 根据院校ID查询套卷
}
