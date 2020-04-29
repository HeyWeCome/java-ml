import com.kang.service.permission.PermissionService;
import com.kang.service.permission.PermissionServiceImpl;
import com.kang.service.sentence.SentenceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 23:45
 * @version: 1.0
 */
public class PermissionTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PermissionService permissionServiceImpl = (PermissionServiceImpl) context.getBean("PermissionServiceImpl");

        String roleId= "0";
        String moduleId = "1";
        System.out.println(permissionServiceImpl.addPermission(roleId,moduleId));
    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PermissionService permissionServiceImpl = (PermissionServiceImpl) context.getBean("PermissionServiceImpl");

        String roleId= "0";
        String moduleId = "1";
        System.out.println(permissionServiceImpl.deletePermission(roleId,moduleId));
    }
}
