import com.kang.pojo.Employee;
import com.kang.service.employee.EmployeeService;
import com.kang.service.employee.EmployeeServiceImpl;
import com.kang.service.questionDiscuss.QuestionDiscussService;
import com.kang.service.questionDiscuss.QuestionDiscussServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
