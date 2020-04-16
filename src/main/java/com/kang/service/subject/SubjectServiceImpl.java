package com.kang.service.subject;

import com.kang.dao.school.SchoolMapper;
import com.kang.dao.sentence.SentenceMapper;
import com.kang.dao.subject.SubjectMapper;
import com.kang.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/16 16:07
 * @version: 1.0
 */
@Service("SubjectServiceImpl")
public class SubjectServiceImpl implements SubjectService {
    // service调用dao层
    @Autowired
    private SubjectMapper subjectMapper;

    public SubjectMapper getSubjectMapper(){
        return subjectMapper;
    }

    public void setSubjectMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    // 通过题目的ID获取题目信息
    public Subject getSubjectById(String id) {
        return subjectMapper.getSubjectById(id);
    }
}
