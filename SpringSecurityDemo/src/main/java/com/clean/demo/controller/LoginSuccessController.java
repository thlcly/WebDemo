package com.clean.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tonghui on 2015/9/25.
 */
@Controller
@RequestMapping("main")
public class LoginSuccessController {

    @RequestMapping("common")
    public String commonPage(){
        return "common";
    }

    @RequestMapping("admin")
    public String adminPage(){
        return "admin";
    }


}
