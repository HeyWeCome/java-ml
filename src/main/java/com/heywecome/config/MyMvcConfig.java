package com.heywecome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
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

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    //ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    // 自定义了一个自己的视图解析器MyResolver
    public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
