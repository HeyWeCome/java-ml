package com.kang.service.subject;

import com.kang.dao.school.SchoolMapper;
import com.kang.dao.sentence.SentenceMapper;
import com.kang.dao.subject.SubjectMapper;
import com.kang.pojo.Subject;
import com.kang.pojo.UserCollection;
import com.kang.pojo.UserNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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

    // 题目的类型：1.单选 2.问答，暂时只考虑这两种 type
    // 题目的具体分类：1.数据结构 2.计网 3.机组 4.操作系统 classify
    public List<Subject> loadAllQuestion() {
        List<Subject> result = subjectMapper.loadAllQuestion();

        for (Subject subject : result) {
            // 截断题目的长度
            int length = subject.getTitle().length();
            if (length > 35){
                subject.setTitle(subject.getTitle().substring(0,35));
            }

            // 设置题目的类型
            if (subject.getType().equals("1")){
                subject.setType("单选题");
            }else{
                subject.setType("简答题");
            }

            // 设置题目的具体分类
            if(subject.getClassify().equals("1")){
                subject.setClassify("数据结构");
            }else if (subject.getClassify().equals("2")){
                subject.setClassify("计算机网络");
            }else if (subject.getClassify().equals("3")){
                subject.setClassify("计算机组成原理");
            }else if (subject.getClassify().equals("4")){
                subject.setClassify("操作系统");
            }
        }
        return result;
    }

    // 根据分类查询题目
    public List<Subject> loadQuestionByClassify(String classify) {
        String classifyDeatil = "";  // 具体的分类，如果没有，就是全部查询

        if(classify.equals("数据结构")){
            classifyDeatil = "1";
        }else if(classify.equals("计算机网络")){
            classifyDeatil = "2";
        }else if(classify.equals("计算机组成原理")){
            classifyDeatil = "3";
        }else if (classify.equals("操作系统")){
            classifyDeatil = "4";
        }else {
            System.out.println("拓展");
        }

        List<Subject> result = subjectMapper.loadQuestionByClassify(classifyDeatil);

        for (Subject subject : result) {
            // 截断题目的长度
            int length = subject.getTitle().length();
            if (length > 35){
                subject.setTitle(subject.getTitle().substring(0,35));
            }

            // 设置题目的类型
            if (subject.getType().equals("1")){
                subject.setType("单选题");
            }else{
                subject.setType("简答题");
            }

            // 设置题目的具体分类
            if(subject.getClassify().equals("1")){
                subject.setClassify("数据结构");
            }else if (subject.getClassify().equals("2")){
                subject.setClassify("计算机网络");
            }else if (subject.getClassify().equals("3")){
                subject.setClassify("计算机组成原理");
            }else if (subject.getClassify().equals("4")){
                subject.setClassify("操作系统");
            }
        }
        return result;
    }

    // 用户添加笔记
    public int addNote(String subjectId, String content, String userId) {
        // 得到32位的uuid
        String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        // 分类默认为空
        String notebookId = "";
        UserNote userNote = new UserNote(id,subjectId,userId,content,notebookId);
        // 返回1是成功
        return subjectMapper.addNote(userNote);
    }

    // 查询用户的笔记
    public UserNote loadNoteById(String subjectId, String userId) {
        return subjectMapper.loadNoteById(subjectId,userId);
    }

    // 检测用户的笔记是否存在着
    public int checkUserNoteExist(String subjectId, String userId) {
        UserNote userNote = subjectMapper.loadNoteById(subjectId, userId);
        if (userNote.getId() != ""){
            return 1;
        }else{
            return 0;
        }
    }

    // 修改笔记
    public int modifyNote(String id, String content) {
        return subjectMapper.modifyNote(id,content);
    }

    // 用户新增收藏
    public int addCollection(String subjectId, String userId) {
        // 得到32位的uuid
        String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        UserCollection userCollection = new UserCollection(id,userId,subjectId);

        // 返回1 新增成功
        return subjectMapper.addCollection(userCollection);
    }

    // 取消收藏，返回的是删除的行数
    public int deleteCollection(String subjectId, String userId) {
        return subjectMapper.deleteCollection(subjectId,userId);
    }

    // 查找用户收藏的题目
    public int searchCollection(String subjectId, String userId) {

        if(subjectMapper.searchCollection(subjectId, userId) == null){
            return 0;
        }else{
            return 1;
        }
    }

    // 查找数据结构的题目个数
    public int searchCountOfDS() {
        return subjectMapper.searchCountOfDS();
    }

    public int searchCountOfNet() {
        return subjectMapper.searchCountOfNet();
    }

    public int searchCountOfOrg() {
        return subjectMapper.searchCountOfOrg();
    }

    public int searchCountOfOp() {
        return subjectMapper.searchCountOfOp();
    }

    // 查看每个类型用户记笔记的个数
    public int searchCountNote(String userId, String type) {
        return subjectMapper.searchCountNote(userId,type);
    }

    public List<HashMap> loadQuestionCollectByUser(String userId, String classify) {
        return subjectMapper.loadQuestionCollectByUser(userId,classify);
    }

    public List<HashMap> loadQuestionNoteByUser(String userId, String classify) {
        return subjectMapper.loadQuestionNoteByUser(userId,classify);
    }

    public Subject loadDailySubject() {
        return subjectMapper.loadDailySubject();
    }
}
