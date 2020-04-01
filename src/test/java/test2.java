import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.Provincial;
import com.kang.pojo.School;
import com.kang.pojo.UserDiary;
import com.kang.service.provincial.ProvincialService;
import com.kang.service.school.SchoolServiceImpl;
import com.kang.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/1 22:43
 * @version: 1.0
 */
public class test2 {
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProvincialService provincialService = (ProvincialService) context.getBean("ProvincialServiceImpl");

        List<Provincial> provincials = provincialService.queryAllProvincial();
        for (Provincial provincial : provincials) {
            System.out.println(provincial.toString());
        }

//        System.out.println(JSONObject.toJSONString(userDiaries));
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SchoolServiceImpl schoolServiceImpl = (SchoolServiceImpl) context.getBean("SchoolServiceImpl");

        List<School> schools = schoolServiceImpl.loadSchoolByProvincial("1");

        for (School school : schools) {
            System.out.println(school.toString());
        }
//        System.out.println(JSONObject.toJSONString(userDiaries));
    }
}
