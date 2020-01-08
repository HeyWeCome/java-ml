package com.heywecome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/1/8 16:14
 * @version: 1.0
 */

@Controller
public class Test {

    @RequestMapping("/test")
    public String success(Model model){
        //存入数据
        model.addAttribute("msg","Hello,Thymeleaf");

        model.addAttribute("users", Arrays.asList("h","k"));
        return "test";
    }
}
