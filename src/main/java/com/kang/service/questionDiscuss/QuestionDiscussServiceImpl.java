package com.kang.service.questionDiscuss;

import com.kang.dao.error.ErrorMapper;
import com.kang.dao.questionDiscuss.QuestionDiscussMapper;
import com.kang.pojo.QuestionDiscuss;
import com.kang.pojo.UserPrefer;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/23 15:51
 * @version: 1.0
 */
@Service("QuestionDiscussServiceImpl")
public class QuestionDiscussServiceImpl implements QuestionDiscussService {
    @Autowired
    private QuestionDiscussMapper questionDiscussMapper;

    public QuestionDiscussMapper getQuestionDiscussMapper(){
        return questionDiscussMapper;
    }

    public void setQuestionDiscussMapper(QuestionDiscussMapper getQuestionDiscussMapper) {
        this.questionDiscussMapper = questionDiscussMapper;
    }

    // 新增题目讨论
    public int addQuestionDiscuss(String questionId, String userId, String content, String parent) {
        // 得到32位的uuid
        String id = kangkang.id_get();
        String time = kangkang.detailTime_get();
        int agree = 0;

        QuestionDiscuss questionDiscuss = new QuestionDiscuss(id, questionId, userId, content, parent, time, agree);
        return questionDiscussMapper.addQuestionDiscuss(questionDiscuss);
    }

    // 查询题目的留言情况
    public List<HashMap> loadQuestionDiscuss(String questionId) {
        return questionDiscussMapper.loadQuestionDiscuss(questionId);
    }

    // 点赞
    public int addAgree(String id, int agree,String userId) {
        String realId = id.substring(0,id.length()-5);

        QuestionDiscuss questionDiscuss = new QuestionDiscuss();
        questionDiscuss.setId(realId);
        questionDiscuss.setAgree(agree);

        // 添加用户喜爱表
        int result = addUserPrefer(realId,userId);

        if(result > 0){
            return questionDiscussMapper.addAgree(questionDiscuss);
        }else{
            return 0;
        }
    }

    // 添加用户对于留言的态度
    private int addUserPrefer(String questionDiscussId, String userId){
        String id = kangkang.id_get();
        UserPrefer userPrefer = new UserPrefer(id,userId,questionDiscussId);

        return questionDiscussMapper.addUserPrefer(userPrefer);
    }

    // 检测用户有没有点击喜欢
    public int checkUserPrefer(String userId, String questionDiscussId) {
        return questionDiscussMapper.checkUserPrefer(userId, questionDiscussId);

    }
}
