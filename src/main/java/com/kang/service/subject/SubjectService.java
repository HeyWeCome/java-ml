package com.kang.service.subject;

import com.kang.pojo.Subject;
import com.kang.pojo.UserCollection;
import com.kang.pojo.UserNote;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface SubjectService {
    Subject getSubjectById(String id);                                    // 通过题目的ID获取题目信息
    int addOneChoice(String title, String classify, String type,String optionA,String optionB,String optionC,String optionD);               // 新增单选题
    int modifyOneChoice(String id,String title, String classify,String optionA,String optionB,String optionC,String optionD);  // 修改单选题的信息
    int deleteSubject(String id);                                                                             // 删除单选
    int addShortAns(String title, String classify, String type,String content);                                 // 新增简答题
    int modifyShortAns(String id,String title, String classify, String content);                    // 修改简答题
    List<Subject> loadAllQuestion();                                      // 查询全部的问题
    List<Subject> loadQuestionByClassify(String classify);                // 根据分类查询题目
    int addNote(String subjectId,String content, String userId);          // 添加笔记
    UserNote loadNoteById(String subjectId,String userId);                // 根据ID查询用户的笔记
    int checkUserNoteExist(String subjectId,String userId);               // 检测用户的笔记是否存在
    int modifyNote(String id,String content);                             // 修改笔记
    int addCollection(String subjectId,String userId);                    // 新增收藏
    int deleteCollection(String subjectId,String userId);                 // 取消收藏
    int searchCollection(String subjectId,String userId);                 // 查找用户收藏题目
    int searchCountOfDS();                                                // 查看数据结构的习题个数
    int searchCountOfNet();                                              // 查看计网的习题个数
    int searchCountOfOrg();                                              // 查看机组的习题个数
    int searchCountOfOp();                                              // 查看操作系统的习题个数
    int searchCountNote(String userId,String type);                      // 查看每个类型用户记笔记的个数
    List<HashMap> loadQuestionCollectByUser(String userId, String classify);  // 根据分类查询题目
    List<HashMap> loadQuestionNoteByUser(String userId, String classify);  // 根据分类查询题目
    Subject loadDailySubject();                                            // 加载每日一题
}
