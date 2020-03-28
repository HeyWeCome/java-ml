package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/5 20:26
 * @version: 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/userLogin",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String userLogin(String userName,String password){

        System.out.println("进来了");
        System.out.println(userName);
        System.out.println(password);

        return JSONObject.toJSONString("ddd");
    }
}
