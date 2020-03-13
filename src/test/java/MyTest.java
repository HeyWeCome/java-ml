import com.kang.pojo.Provincial;
import com.kang.service.provincial.ProvincialService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ProvincialService provincialServiceImpl = (ProvincialService) context.getBean("provincialServiceImpl");

        for (Provincial provincial : provincialServiceImpl.queryAllProvincial()) {
            System.out.println(provincial);
        }
    }
}
