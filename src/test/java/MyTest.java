import com.kang.pojo.Provincial;
import com.kang.service.provincial.ProvincialService;
import com.kang.service.sentence.SentenceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/13 15:29
 * @version: 1.0
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceService sentenceService = (SentenceService) context.getBean("SentenceServiceImpl");

        String sentence = sentenceService.loadOneSentence();
        System.out.println(sentence);
    }
}
