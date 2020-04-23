package com.kang.service.questionDiscuss;

import com.kang.pojo.QuestionDiscuss;

import java.util.HashMap;
import java.util.List;

public interface QuestionDiscussService {
    int addQuestionDiscuss(String questionId, String userId, String content,String parent);                // 新增问题讨论回复
    List<HashMap> loadQuestionDiscuss(String questionId);                                                  // 查询题目的留言情况
}
