package com.kang.service.question;

import com.kang.dao.provincial.ProvincialMapper;
import com.kang.dao.question.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/3 10:20
 * @version: 1.0
 */
@Service("QuestionServiceImpl")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionMapper getQuestionMapper(){
        return questionMapper;
    }

    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    // 根据院校id查询,返回所有套卷
    public List<HashMap> loadQuestionBySchool(String schoolId) {
        return questionMapper.loadQuestionBySchool(schoolId);
    }

    // 查询试卷的存储地址
    public String searchTestPaperById(String id) {
        return questionMapper.searchTestPaperById(id);
    }

    // 新增套卷的热度
    public int addTestPaperHeat(String id) {
        return questionMapper.addTestPaperHeat(id);
    }

}
