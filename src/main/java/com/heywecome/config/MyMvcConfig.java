package com.heywecome.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @description: 全面拓展 springmvc
 * @author: HeyWeCome
 * @createDate: 2020/1/8 16:41
 * @version: 1.0
 */

// 如果我们翔diy一些定制化的功能，只要写了这个组件，然后把它交给springboot，springboot就会帮我们自动装配
// 拓展springmvc dispatchservlet
// 如果我们要扩展springmvc，官方建议我们这样去做
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
