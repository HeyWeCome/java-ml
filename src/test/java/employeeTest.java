import com.kang.pojo.Employee;
import com.kang.service.employee.EmployeeService;
import com.kang.service.employee.EmployeeServiceImpl;
import com.kang.service.questionDiscuss.QuestionDiscussService;
import com.kang.service.questionDiscuss.QuestionDiscussServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/28 14:52
 * @version: 1.0
 */
public class employeeTest {
    @Test
    public void addQuestionDiscuss(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeServiceImpl) context.getBean("EmployeeServiceImpl");

        String account = "admin";
        String password = "123456";

        Employee employee = employeeService.employeeLogin(account, password);

        System.out.println(employee.toString());
    }

    @Test
    public void loadAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeServiceImpl) context.getBean("EmployeeServiceImpl");

        List<HashMap> hashMaps = employeeService.loadAllEmployeeAndRole();

        System.out.println(hashMaps.toString());

    }

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeServiceImpl) context.getBean("EmployeeServiceImpl");

        String name = "何总123";
        String sex = "1";
        String account = "heywecome";
        String password = "123456";
        String roleId = "0";

        employeeService.addEmployee(name,sex,account,password,roleId);

    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeServiceImpl) context.getBean("EmployeeServiceImpl");

        String id = "931b2de180d94f77b4036602a2746a6d";
        String name = "何总";
        String sex = "1";
        String account = "heywecome";
        String password = "123456";
        String roleId = "0";

        employeeService.deleteEmployee(id);

    }
}
