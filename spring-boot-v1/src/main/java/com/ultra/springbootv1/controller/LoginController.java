package com.ultra.springbootv1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        logger.info("----------------------用户 : " + username + ", 密码 : " + password + " login success...");
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("username", username);
        mv.addObject("password", password);
        return mv;
    }

}
