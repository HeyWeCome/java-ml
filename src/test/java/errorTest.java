import com.kang.service.error.ErrorServiceImpl;
import com.kang.service.subject.SubjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/23 15:02
 * @version: 1.0
 */
public class errorTest {
    @Test
    public void addError(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ErrorServiceImpl errorService = (ErrorServiceImpl) context.getBean("ErrorServiceImpl");

        String questionId = "0a4de35d6e81493fb3f03265cb6bb391";
        String reporterId = "1";
        String reason = "答案错误，应为B";

        System.out.println(errorService.addError(questionId,reporterId,reason));
    }

    @Test
    public void modify(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ErrorServiceImpl errorService = (ErrorServiceImpl) context.getBean("ErrorServiceImpl");

        String id = "ddddddd";
        String questionId = "0a4de35d6e81493fb3f03265cb6bb391";
        String reporterId = "1";
        String reason = "答案错误，应为B";
        String status = "1";

        System.out.println(errorService.modifyStatus(id,status));
    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ErrorServiceImpl errorService = (ErrorServiceImpl) context.getBean("ErrorServiceImpl");

        String id = "ddddddd";
        String questionId = "0a4de35d6e81493fb3f03265cb6bb391";
        String reporterId = "1";
        String reason = "答案错误，应为B";
        String status = "1";

        System.out.println(errorService.delete(id));
    }

    @Test
    public void loadAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ErrorServiceImpl errorService = (ErrorServiceImpl) context.getBean("ErrorServiceImpl");

        System.out.println(errorService.loadAllError().toString());
    }
}
