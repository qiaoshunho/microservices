package com.ultra.springbootv1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/17
 */
@RestController
public class IndexController {

/*    private UserService userService;

    @Autowired
    public IndexController(UserServiceImpl userService) {
        this.userService = userService;
    }*/

    //1.关联查询
    public ModelAndView getUserList() {
        //userService.getPageUserList1(1l, 1, 5);
        return null;
    }
    //2.分页查询
}
