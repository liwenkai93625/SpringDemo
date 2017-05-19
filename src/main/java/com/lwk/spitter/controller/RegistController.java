package com.lwk.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by lianjia on 2017-5-18.
 */
@Controller
public class RegistController {

    @RequestMapping(value = "/register", method = GET)
    public String regist(){
        return "regist";
    }
}
