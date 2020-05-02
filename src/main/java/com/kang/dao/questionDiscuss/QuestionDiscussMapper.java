package com.kang.dao.questionDiscuss;

import com.kang.pojo.QuestionDiscuss;
import com.kang.pojo.UserPrefer;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface QuestionDiscussMapper {
    List<HashMap> loadAllQuestionDiscuss();                                                                             // 查询所有的留言情况
    int addQuestionDiscuss(QuestionDiscuss questionDiscuss);                                                            // 新增问题讨论回复
    int modifyDiscussContent(@Param("id") String id,@Param("content") String content);                                  // 修改讨论的内容
    int deleteQuestionDiscuss(String id);                                                                               // 删除问题讨论
    List<HashMap> loadQuestionDiscuss(String questionId);                                                               // 查询题目的留言情况
    int addAgree(QuestionDiscuss questionDiscuss);                                                                      // 点赞
    int deleteAgree(QuestionDiscuss questionDiscuss);                                                                   // 取消赞
    int addUserPrefer(UserPrefer userPrefer);                                                                           // 添加用户喜好
    int deleteUserPrefer(@Param("questionDiscussId") String questionDiscussId,@Param("userId") String userId);           // 删除用户的点赞
    int checkUserPrefer(@Param("userId") String userId,@Param("questionDiscussId") String questionDiscussId);            // 检测用户有没有点击喜欢
    int loadCollectionCount(String questionId);                                                                          // 检测所有的收藏
}
