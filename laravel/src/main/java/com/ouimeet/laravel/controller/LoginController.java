package com.ouimeet.laravel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @Author: ZhaoJP
 * @Date: 2018/12/13
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/toLogin")
    public String toLogin() {

        return "login";
    }

    @RequestMapping("/checkInfo")
    public ModelAndView checkInfo(@RequestParam String username, @RequestParam String password) {
        System.out.println("--------------username:" + username + ", password:" + password);
        //对用户名 密码进行校验
        ModelAndView mv = new ModelAndView();
        if (username.equals("admin")) {
            mv.setViewName("main");
            return mv;
        }
        mv.setViewName("login");
        mv.addObject("username", username);
        mv.addObject("tips", "用户名或密码错误");
        return mv;
    }

    public String logout() {
        return null;
    }
}
