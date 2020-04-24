package com.kang.dao.questionDiscuss;

import com.kang.pojo.QuestionDiscuss;
import com.kang.pojo.UserPrefer;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface QuestionDiscussMapper {
    int addQuestionDiscuss(QuestionDiscuss questionDiscuss);                // 新增问题讨论回复
    List<HashMap> loadQuestionDiscuss(String questionId);                   // 查询题目的留言情况
    int addAgree(QuestionDiscuss questionDiscuss);                          // 点赞
    int addUserPrefer(UserPrefer userPrefer);                               // 添加用户喜好
    int checkUserPrefer(@Param("userId") String userId,@Param("questionDiscussId") String questionDiscussId);            // 检测用户有没有点击喜欢
}
