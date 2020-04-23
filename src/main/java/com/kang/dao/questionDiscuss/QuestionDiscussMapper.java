package com.kang.dao.questionDiscuss;

import com.kang.pojo.QuestionDiscuss;

import java.util.HashMap;
import java.util.List;

public interface QuestionDiscussMapper {
    int addQuestionDiscuss(QuestionDiscuss questionDiscuss);                // 新增问题讨论回复
    List<HashMap> loadQuestionDiscuss(String questionId);                   // 查询题目的留言情况
}
