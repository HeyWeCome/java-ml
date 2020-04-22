package com.kang.dao.subject;

import com.kang.pojo.Subject;
import com.kang.pojo.UserNote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    Subject getSubjectById(String id);                                                                          // 通过题目的ID获取题目信息
    List<Subject> loadAllQuestion();                                                                            // 查询全部的问题
    List<Subject> loadQuestionByClassify(String classify);                                                      // 根据分类查询题目
    int addNote(UserNote userNote);                                                                             // 添加用户笔记
    UserNote loadNoteById(@Param("subjectId") String subjectId,@Param("userId") String userId);                // 根据ID查询用户的笔记
    int modifyNote(@Param("id") String id,@Param("content") String content);                                    // 修改用户的笔记

}
