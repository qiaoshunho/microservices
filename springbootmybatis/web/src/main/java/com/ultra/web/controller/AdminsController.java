package com.ultra.web.controller;

import com.github.pagehelper.PageInfo;
import com.ultra.model.Admins;
import com.ultra.web.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/3/19
 */
@Controller
@RequestMapping(value = "/admins")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;


    @ResponseBody
    @RequestMapping("/all")
    public Object findAllAdmins(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        PageInfo<Admins> pageInfo = adminsService.findAllUser(pageNum, pageSize);
        for (Admins admin : pageInfo.getList()) {
            System.out.println(admin);
        }
        return pageInfo;
    }

    @RequestMapping("/allAdminReturnJsp")
    public ModelAndView allAdminReturnJsp(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        PageInfo<Admins> pageInfo = adminsService.findAllUser(pageNum, pageSize);
        for (Admins admin : pageInfo.getList()) {
            System.out.println(admin);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("findAllAdmins");
        return mv;
    }

}
