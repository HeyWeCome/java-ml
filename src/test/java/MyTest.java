import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.Provincial;
import com.kang.pojo.User;
import com.kang.pojo.UserDiary;
import com.kang.service.provincial.ProvincialService;
import com.kang.service.sentence.SentenceService;
import com.kang.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        SentenceService sentenceService = (SentenceService) context.getBean("SentenceServiceImpl");

        String sentence = sentenceService.loadOneSentence();
        System.out.println(sentence);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserServiceImpl");

        System.out.println(userService.modifyUserNameById("1", "kangkang"));
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserServiceImpl");

        User user = userService.userLogin("heywecome", "123456");

        System.out.println(user.toString());
    }

    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserServiceImpl");

        User user = new User();
        user.setId();
        user.setAccount("test");
        user.setPassword("123456");
        user.setName("康爸爸");

        System.out.println(userService.register(user));
    }

    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserServiceImpl");


        System.out.println(userService.deleteDiary("1","56e7df87f8cf4db9aa4984e85618c9cc"));
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserServiceImpl");

        // UUID生成ID,同时去掉"-"
        String id = UUID.randomUUID().toString().replace("-","");
        //设置日期格式 并转化为字符串
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String createTime = datetime.format((new Date()));

        String userId = "1";
        String content = "我爱你\n" +
                "                ，如果我给你寄一本书，我不会寄我的诗歌\n" +
                "                ，我会寄你一本关于植物的书\n" +
                "                ，告诉你稻子和稗子的区别\n" +
                "                ，告诉你稗子那提心吊胆的春天。";
        UserDiary userDiary = new UserDiary(id,userId,content,createTime);

        System.out.println(createTime);

        System.out.println(userService.addDairy(userDiary));
        System.out.println(userDiary.getId());
    }
}
