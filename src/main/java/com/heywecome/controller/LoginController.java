package com.heywecome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/1/10 21:25
 * @version: 1.0
 */

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model){

        // 具体的业务：判断用户
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            // 成功则重定向到main.html
            return "redirect:/main.html";
        }else{
            // 告诉用户你登录失败了
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }

    }
}
