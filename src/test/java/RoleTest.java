import com.kang.service.module.ModuleService;
import com.kang.service.module.ModuleServiceImpl;
import com.kang.service.role.RoleService;
import com.kang.service.role.RoleServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 22:45
 * @version: 1.0
 */
public class RoleTest {
    @Test
    public void loadAllRole(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleServiceImpl) context.getBean("RoleServiceImpl");

        System.out.println(roleService.loadAllRole());

    }

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleServiceImpl) context.getBean("RoleServiceImpl");

        String name = "测试";
        String description = "测试数据";

        System.out.println(roleService.addRole(name,description));
    }

    @Test
    public void modify(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleServiceImpl) context.getBean("RoleServiceImpl");

        String id = "58a30a334dfb46e8adfd7186e08d8be6";
        String name = "测试321";
        String description = "测试数据231";

        System.out.println(roleService.modifyRole(id,name,description));
    }

    @Test
    public void deleteRole(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleServiceImpl) context.getBean("RoleServiceImpl");

        String id = "e78689a9aae24f21b72bfc61fcd8b1cd";

        System.out.println(roleService.deleteRole(id));

    }
}
