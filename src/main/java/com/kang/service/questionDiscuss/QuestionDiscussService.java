package com.kang.service.questionDiscuss;

import com.kang.pojo.QuestionDiscuss;
import com.kang.pojo.UserPrefer;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface QuestionDiscussService {
    List<HashMap> loadAllQuestionDiscuss();                                                                // 查询所有的留言情况
    int addQuestionDiscuss(String questionId, String userId, String content,String parent);                // 新增问题讨论回复
    int modifyDiscussContent(String id,String content);                                                     // 修改讨论的内容
    List<HashMap> loadQuestionDiscuss(String questionId);                                                  // 查询题目的留言情况
    int addAgree(String id, int agree,String userId);                                                      // 点赞
    int deleteAgree(String id, int agree,String userId);                                                   // 取消赞
    int checkUserPrefer(String userId, String questionDiscussId);                                           // 检测用户有没有点击喜欢
    int loadCollectionCount(String questionId);                                                             // 检测题目的收藏数量
    int deleteQuestionDiscuss(String id);                                                                               // 删除问题讨论
}