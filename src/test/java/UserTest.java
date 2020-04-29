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

        String id = "1083351f04d74a779fa6bfb1f033ea43";
        String name = "用户哥";
        String account = "testMan";
        String password = "123456";
        String email = "971334911@qq.com";
        String phoneNumber = "10086";
        String address = "北京";

        int i = userService.modifyUser(id, name, account, password, email, phoneNumber, address);
        System.out.println(i);
    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserServiceImpl) context.getBean("UserServiceImpl");


        System.out.println(userService.deleteUser("1083351f04d74a779fa6bfb1f033ea431"));
    }
}
