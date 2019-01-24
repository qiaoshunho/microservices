package com.ultra.springbootv1.controller;

import com.ultra.springbootv1.model.master.UserInfo;
import com.ultra.springbootv1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @Author: ZhaoJP
 * @Date: 2018/12/13
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String toLogin() {

        return "login.html";
    }

    @PostMapping("/savelogin")
    public ModelAndView savelogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        UserInfo userInfo = userService.getUserByName(username);
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(userInfo)) {
            throw new RuntimeException("用户名或密码错误");
        }

        session.setAttribute("user", userInfo);
        logger.info("----------------------用户 : " + username + ", 密码 : " + password + " login success...");
        mv.setViewName("success");
        mv.addObject("username", username);
        mv.addObject("password", password);
        return mv;
    }

    public String logout() {
        return null;
    }
}
