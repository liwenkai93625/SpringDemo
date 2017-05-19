package com.lwk.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by lianjia on 2017-5-18.
 */
@Controller // 声明为一个控制器
@RequestMapping({"/", "/homePage"})
public class HomeController {

    @RequestMapping(method = GET) //处理对"/"的GET请求
    public String home() {
        return "home"; //视图名为 home
    }
}
