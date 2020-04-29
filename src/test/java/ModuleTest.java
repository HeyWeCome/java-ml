import com.kang.pojo.Module;
import com.kang.service.module.ModuleService;
import com.kang.service.module.ModuleServiceImpl;
import com.kang.service.sentence.SentenceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/29 21:43
 * @version: 1.0
 */
public class ModuleTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ModuleService moduleService = (ModuleServiceImpl) context.getBean("ModuleServiceImpl");

        List<Module> modules = moduleService.loadAllModule();

        for (Module module : modules) {
            System.out.println(module.toString());
        }
    }

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ModuleService moduleService = (ModuleServiceImpl) context.getBean("ModuleServiceImpl");

        String name = "测试";
        String status = "1";
        String description = "测试数据";

        System.out.println(moduleService.addModule(name, status, description));

    }

    @Test
    public void modify(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ModuleService moduleService = (ModuleServiceImpl) context.getBean("ModuleServiceImpl");

        String id = "0144815e48b34e769f2389be356c6735";
        String name = "测试4343243";
        String status = "1";
        String description = "测试数据";

        System.out.println(moduleService.modifyModule(id,name, status, description));

    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ModuleService moduleService = (ModuleServiceImpl) context.getBean("ModuleServiceImpl");

        String id = "0144815e48b34e769f2389be356c6735";
        String name = "测试";
        String status = "1";
        String description = "测试数据";

        System.out.println(moduleService.deleteModule(id));

    }
}
