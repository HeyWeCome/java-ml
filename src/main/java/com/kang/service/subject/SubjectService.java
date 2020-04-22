package com.kang.service.subject;

import com.kang.pojo.Subject;
import com.kang.pojo.UserNote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectService {
    Subject getSubjectById(String id);                                    // 通过题目的ID获取题目信息
    List<Subject> loadAllQuestion();                                      // 查询全部的问题
    List<Subject> loadQuestionByClassify(String classify);                // 根据分类查询题目
    int addNote(String subjectId,String content, String userId);          // 添加笔记
    UserNote loadNoteById(String subjectId,String userId);                // 根据ID查询用户的笔记
    int checkUserNoteExist(String subjectId,String userId);               // 检测用户的笔记是否存在
    int modifyNote(String id,String content);                             // 修改笔记
}
