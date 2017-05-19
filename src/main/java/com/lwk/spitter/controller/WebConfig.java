package com.lwk.spitter.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by lianjia on 2017-5-18.
 *
 * 配置web.xml
 */
@Configuration //表示这是一个配置类
@EnableWebMvc //启用SpringMVC
@ComponentScan("com.lwk.spitter.controller") //启动组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean  //注册一个视图解析器bean
    public ViewResolver viewResolver() {
        //配置JSP视图解析器
        InternalResourceViewResolver resovler =
                new InternalResourceViewResolver();
        resovler.setPrefix("WEB-INF/views/jsp/");
        resovler.setSuffix(".jsp");
        resovler.setExposeContextBeansAsAttributes(true);
        return resovler;
    }

    //配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        /*通过调用DefaultServletHandlerConfigurer的enable()方法，要求DispatcherServlet将
         *对静态资源的请求转发到Servlet容器中默认的servlet上，而不是使用DIspatcherServlet本
         *身来处理此类请求。
         */
        configurer.enable();
    }
}