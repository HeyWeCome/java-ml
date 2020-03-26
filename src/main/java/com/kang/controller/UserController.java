package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.UserDiary;
import com.kang.service.user.UserService;
import com.kang.service.user.UserServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @description: 用户的控制类
 * @author: HeyWeCome
 * @createDate: 2020/3/25 21:45
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService =  new UserServiceImpl();

    @RequestMapping(value = "/postDairy",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postDairy(String userId,String content){
        // UUID生成ID,同时去掉"-"
        String id = UUID.randomUUID().toString().replace("-","");
        //设置日期格式 并转化为字符串
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String createTime = datetime.format((new Date()));

        UserDiary userDiary = new UserDiary(id,userId,content,createTime);

        System.out.println(userService.addDairy(userDiary));


        return JSONObject.toJSONString("ccc");
    }
}
