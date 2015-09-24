package com.clean.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tonghui on 2015/9/25.
 */
@Controller
@RequestMapping("auth")
public class LoginController {

    @RequestMapping(value = "login")
    public ModelAndView login(@RequestParam(value = "error" , required = false)Boolean error){
        ModelAndView mv = new ModelAndView("login");
        if(error != null && error){
            mv.addObject("error","login failed");
        }
        return mv;
    }

    @RequestMapping(value = "denied")
    public ModelAndView deniedPage(){
        return new ModelAndView("denied");
    }
}
