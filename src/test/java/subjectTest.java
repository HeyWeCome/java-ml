import com.kang.pojo.Subject;
import com.kang.pojo.UserNote;
import com.kang.service.sentence.SentenceService;
import com.kang.service.subject.SubjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/16 16:19
 * @version: 1.0
 */
public class subjectTest {
    @Test
    public void searchSubject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        Subject subjectById = (Subject) subjectService.getSubjectById("8c19f371d6134a4bbe5f301adbf3ecdf");
        System.out.println(subjectById.toString());

    }

    @Test
    public void addOneChoice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String title = "测试数据";
        String classify ="1";
        String type = "1";
        String optionA ="测试A";
        String optionB = "测试B";
        String optionC = "测试C";
        String optionD = "测试D";

        System.out.println(subjectService.addOneChoice(title, classify, type, optionA, optionB, optionC, optionD));

    }

    @Test
    public void addShortAns(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String title = "测试数据";
        String classify ="1";
        String type = "1";
        String content = "测试测试测试";
        String optionA ="测试A";
        String optionB = "测试B";
        String optionC = "测试C";
        String optionD = "测试D";

        System.out.println(subjectService.addShortAns(title, classify, type, content));

    }

    @Test
    public void modifyShortAns(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String id = "b0648000f8804a14940d1181c1f7fa87";
        String title = "测试数据321321132";
        String classify ="1";
        String type = "1";
        String content = "测试测试测试";
        String optionA ="测试A";
        String optionB = "测试B";
        String optionC = "测试C";
        String optionD = "测试D";

        System.out.println(subjectService.modifyShortAns(id,title, classify,content));

    }

    @Test
    public void modifyOneChoice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String id = "8a2b4ae280904234856c3a284fa41c8c";
        String title = "测试数据";
        String classify ="2";
        String optionA ="测试A";
        String optionB = "测试B";
        String optionC = "测试C";
        String optionD = "测试D";

        System.out.println(subjectService.modifyOneChoice(id,title, classify,optionA, optionB, optionC, optionD));

    }

    @Test
    public void deleteOneChoice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String id = "b0648000f8804a14940d1181c1f7fa87";

        System.out.println(subjectService.deleteSubject(id));

    }

    @Test
    public void searchAllSubject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        List<Subject> subjects = subjectService.loadAllQuestion();

        for (Subject subject : subjects) {
            System.out.println(subject.toString());
        }
    }

    @Test
    public void loadQuestionByClassify(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        List<Subject> subjects = subjectService.loadQuestionByClassify("计算机网络");

        for (Subject subject : subjects) {
            System.out.println(subject.toString());
        }
    }

    @Test
    public void addNote(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";
        String content = "磁盘何内存的速度差异，决定了可以将内存经常访问的文件调入磁盘缓冲区";

        int i = subjectService.addNote(subjectId, content, userId);
        System.out.println(i);
    }

    @Test
    public void loadNoteById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";
        String content = "磁盘何内存的速度差异，决定了可以将内存经常访问的文件调入磁盘缓冲区";

        UserNote userNote = subjectService.loadNoteById(subjectId, userId);

        System.out.println(userNote.toString());
    }

    @Test
    public void addColection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";

        System.out.println(subjectService.addCollection(subjectId, userId));
    }

    @Test
    public void deleteColection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";

        System.out.println(subjectService.deleteCollection(subjectId, userId));
    }

    @Test
    public void searchColection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";

        System.out.println(subjectService.searchCollection(subjectId, userId));
    }

    @Test
    public void ddd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";

        List<HashMap> hashMaps = subjectService.loadQuestionCollectByUser("1", "1");

        for (HashMap hashMap : hashMaps) {
            System.out.println(hashMap.toString());
        }
//        System.out.println(subjectService.searchCollection(subjectId, userId));
    }

    @Test
    public void sss(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectService = (SubjectService) context.getBean("SubjectServiceImpl");

        String subjectId = "0a4de35d6e81493fb3f03265cb6bb391";
        String userId = "1";

        Subject subject = subjectService.loadDailySubject();
        System.out.println(subject.toString());
    }
}
