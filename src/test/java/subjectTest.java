import com.kang.pojo.Subject;
import com.kang.service.sentence.SentenceService;
import com.kang.service.subject.SubjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
