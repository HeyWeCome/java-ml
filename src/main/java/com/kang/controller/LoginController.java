package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.User;
import com.kang.service.user.UserService;
import com.kang.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//    @Autowired
//    private UserService userService =  new UserServiceImpl();
//
//
//}
