import com.kang.service.discussCorrection.DiscussCorrectionService;
import com.kang.service.discussCorrection.DiscussCorrectionServiceImpl;
import com.kang.service.questionDiscuss.QuestionDiscussService;
import com.kang.service.questionDiscuss.QuestionDiscussServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/25 20:45
 * @version: 1.0
 */
public class discussTest {
    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DiscussCorrectionService discussCorrectionService = (DiscussCorrectionServiceImpl) context.getBean("DiscussCorrectionServiceImpl");

        String discussId = "b16af286972546409a15779e30ba7034";
        String reporterId = "1";
        String content = "dsadsad";

        System.out.println(discussCorrectionService.addDiscussCorrection(discussId,reporterId,content));
    }
}
