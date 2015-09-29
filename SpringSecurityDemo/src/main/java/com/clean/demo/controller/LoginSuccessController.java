package com.clean.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tonghui on 2015/9/25.
 */
@Controller
@RequestMapping("main")
public class LoginSuccessController {

    @RequestMapping(value = "common",method = RequestMethod.GET)
    public String commonPage(){
        return "common";
    }

    @RequestMapping(value = "admin",method = RequestMethod.POST)
    public String adminPage(@RequestParam(value = "name",required = false)String name,@RequestParam(value = "hobby",required = false)String hobby){
        return "admin";
    }


}
