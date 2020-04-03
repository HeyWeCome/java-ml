package com.kang.service.question;

import java.util.HashMap;
import java.util.List;

public interface QuestionService {
    List<HashMap> loadQuestionBySchool(String schoolId);        // 根据院校ID查询套卷
}
