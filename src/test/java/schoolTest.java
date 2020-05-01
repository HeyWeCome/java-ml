import com.kang.pojo.School;
import com.kang.pojo.Subject;
import com.kang.service.school.SchoolService;
import com.kang.service.school.SchoolServiceImpl;
import com.kang.service.subject.SubjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/5/1 14:54
 * @version: 1.0
 */
public class schoolTest {
    @Test
    public void searchSubject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SchoolService schoolService = (SchoolServiceImpl) context.getBean("SchoolServiceImpl");

        List<School> schools = schoolService.loadAllSchoolAndProvincial();
        System.out.println(schools.toString());
    }

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SchoolService schoolService = (SchoolServiceImpl) context.getBean("SchoolServiceImpl");

        String name = "1";
        String provincial="1";
        String location="1";
        String introduction="1";
        String postCode = "1";
        String photo = "";


        System.out.println(schoolService.addSchool(name,provincial,location,photo,introduction,postCode));
    }

    @Test
    public void modify(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SchoolService schoolService = (SchoolServiceImpl) context.getBean("SchoolServiceImpl");

        String id = "73d25e300a19431787a5977fbd25eff4";
        String name = "132312";
        String provincial="1";
        String location="1";
        String introduction="1";
        String postCode = "1";
        String photo = "";

        System.out.println(schoolService.modifySchool(id,name,provincial,location,introduction,postCode));
    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SchoolService schoolService = (SchoolServiceImpl) context.getBean("SchoolServiceImpl");

        String id = "73d25e300a19431787a5977fbd25eff4";

        System.out.println(schoolService.deleteSchool(id));
    }
}
