package com.heywecome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 跳转首页
 * @author: HeyWeCome
 * @createDate: 2020/1/6 22:25
 * @version: 1.0
 */

// 在templates目录下的所有页面，只能通过controller来跳转
// 这个需要模板引擎支持！ thymeleaf
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
