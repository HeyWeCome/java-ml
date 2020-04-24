import com.kang.service.questionDiscuss.QuestionDiscussService;
import com.kang.service.questionDiscuss.QuestionDiscussServiceImpl;
import com.kang.service.subject.SubjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/23 15:59
 * @version: 1.0
 */
public class questionTest {
    @Test
    public void addQuestionDiscuss(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionDiscussService questionDiscussService = (QuestionDiscussServiceImpl) context.getBean("QuestionDiscussServiceImpl");

        String questionId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";
        String content = "磁盘和内存的速度差异，决定了可以将内存经常访问的文件调入磁盘缓冲区，从高速缓存中复制的访问比磁盘I/O的机械操作要快很多很多。";

        System.out.println(questionDiscussService.addQuestionDiscuss(questionId,userId,content,"0"));
    }

    @Test
    public void loadQuestionDiscuss(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionDiscussService questionDiscussService = (QuestionDiscussServiceImpl) context.getBean("QuestionDiscussServiceImpl");

        String questionId = "0a4de35d6e81493fb3f03265cb6bb391";

        List<HashMap> hashMaps = questionDiscussService.loadQuestionDiscuss(questionId);
        for (HashMap hashMap : hashMaps) {
            System.out.println(hashMap.toString());
        }
//        System.out.println();
    }

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionDiscussService questionDiscussService = (QuestionDiscussServiceImpl) context.getBean("QuestionDiscussServiceImpl");

        String questionId = "0a4de35d6e81493fb3f03265cb6bb391";
        String questionDiscussId = "b16af286972546409a15779e30ba7034agree";
        String userId = "1";

        System.out.println(questionDiscussService.addAgree(questionDiscussId, 22, userId));
    }

    @Test
    public void check(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionDiscussService questionDiscussService = (QuestionDiscussServiceImpl) context.getBean("QuestionDiscussServiceImpl");

        String questionDiscussId = "b16af286972546409a15779e30ba7034";
        String userId = "1";

        System.out.println(questionDiscussService.checkUserPrefer(userId,questionDiscussId));
    }
}
