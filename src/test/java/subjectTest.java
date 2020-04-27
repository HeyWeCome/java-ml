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
