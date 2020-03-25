package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 用户的控制类
 * @author: HeyWeCome
 * @createDate: 2020/3/25 21:45
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/postDairy",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postDairy(String userId,String content){

        System.out.println("进来lpostDairy");
        System.out.println(userId);
        System.out.println(content);

        return JSONObject.toJSONString("ccc");
    }
}
