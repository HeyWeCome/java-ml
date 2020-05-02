import com.kang.pojo.Provincial;
import com.kang.service.provincial.ProvincialService;
import com.kang.service.user.UserService;
import com.kang.service.user.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 14:57
 * @version: 1.0
 */
public class UserTest {

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserServiceImpl) context.getBean("UserServiceImpl");

        String id = "e6fa6105188d4f41b0e32b9de8493047";

        System.out.println(userService.loadModule(id).toString());
    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserServiceImpl) context.getBean("UserServiceImpl");


        System.out.println(userService.deleteUser("1083351f04d74a779fa6bfb1f033ea431"));
    }
}
