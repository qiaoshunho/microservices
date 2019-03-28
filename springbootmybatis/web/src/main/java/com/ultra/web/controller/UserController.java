package com.ultra.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultra.web.dao.UserMapper;
import com.ultra.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //请求例子：http://localhost:8080/getUserWithCompany/1
    /*请求结果：{"id":1,"name":"aa","company":{"id":1,"companyName":"xx公司"},"accounts":null}*/
    @RequestMapping("/getUserWithCompany/{id}")
    public User getUserWithCompany(@PathVariable("id") Long id) {
        User user = userMapper.getUserWithCompany(id);
        return user;
    }


    //请求例子：http://localhost:8080/getUserWithAccount/1
    /*请求结果：{"id":1,"name":"aa","company":null,"accounts":[{"id":1,"accountName":"中行"},{"id":2,"accountName":"工行"}]}*/
    @RequestMapping("/getUserWithAccount/{id}")
    public User getUserWithAccount(@PathVariable("id") Long id) {
        User user = userMapper.getUserWithAccount(id);
        return user;
    }


    //请求例子：http://localhost:8080/getUsers
    /*请求结果：[{"id":1,"name":"aa","company":{"id":1,"companyName":"xx公司"},"accounts":[{"id":1,"accountName":"中行"},{"id":2,"accountName":"工行"}]},{"id":2,"name":"bb","company":{"id":2,"companyName":"yy公司"},"accounts":
[{"id":3,"accountName":"中行"}]}]*/
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    //分页
    @RequestMapping("/getUsersPage")
    public PageInfo<User> getUsersPage() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.getAll();
        PageInfo result = new PageInfo(users);
        return result;
    }

    @RequestMapping("/getUsersByXml")
    public List<User> getUsersByXml() {
        List<User> users = userMapper.getAll();
        return users;
    }

}
