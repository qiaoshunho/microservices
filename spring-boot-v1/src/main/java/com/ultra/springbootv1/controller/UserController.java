package com.ultra.springbootv1.controller;

import com.ultra.springbootv1.common.page.PageTool;
import com.ultra.springbootv1.model.master.UserInfo;
import com.ultra.springbootv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/27
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser")
    public List<UserInfo> getAllUser() {
        List<UserInfo> users = userService.getAllUserList();
        return users;
    }

    /**
     * 缓存测试
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/getAllUserByCache")
    public UserInfo getAllUserByCache(@RequestParam String name) {
        UserInfo user = userService.getUserByNameByCache(name);
        return user;
    }

    @RequestMapping(value = "/getUsers")
    public ModelAndView getUsers(@RequestParam(name = "page", required = false) Integer page,
                                 @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        PageTool pageTool = userService.dynamicSQL2(page, pageSize);
        ModelAndView mav = new ModelAndView("userInfo");
        mav.addObject("obj", pageTool);
        return mav;
    }

}
