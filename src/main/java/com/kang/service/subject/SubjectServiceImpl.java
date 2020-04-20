package com.kang.service.subject;

import com.kang.dao.school.SchoolMapper;
import com.kang.dao.sentence.SentenceMapper;
import com.kang.dao.subject.SubjectMapper;
import com.kang.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
