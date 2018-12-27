package com.ultra.springbootv1.controller;

import com.ultra.springbootv1.model.UserInfo;
import com.ultra.springbootv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/27
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser")
    public List<UserInfo> getAllUser(){
        List<UserInfo> users = userService.getAllUserList();
        return users;
    }

    /**
     * 缓存测试
     * @param name
     * @return
     */
    @GetMapping(value = "/getAllUserByCache")
    public UserInfo getAllUserByCache(@RequestParam String name){
        UserInfo user = userService.getUserByNameByCache(name);
        return user;
    }

}
