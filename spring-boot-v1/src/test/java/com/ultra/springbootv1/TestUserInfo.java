package com.ultra.springbootv1;

import com.ultra.springbootv1.common.page.PageTool;
import com.ultra.springbootv1.model.ResultMap;
import com.ultra.springbootv1.model.UserInfo;
import com.ultra.springbootv1.repository.UserInfoRepository;
import com.ultra.springbootv1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserInfo {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    //增加
    @Test
    public void addUser() {
        userService.addUserInfo(new UserInfo());
    }

    @Test
    public void deleteUser() {
        userService.deleteUserInfoById(16l);
    }

    @Test
    public void updateUser() {
        userService.updateUser(new UserInfo());
    }

    @Test
    public void getUserByName() {
        UserInfo userInfo = userService.getUserByName("admin");
        System.out.println(userInfo);
    }

    @Test
    public void getAllUser() {
        List<UserInfo> users = userService.getAllUserList();
        for (UserInfo user : users) {
            System.out.println(user);
        }
    }

    //多表关联查询,返回一个数组的结果集,没有实现分页
    @Test
    public void getAllUserForObject() {
        List<Object[]> users = userService.getAllUserForObject();
        for (Object[] user : users) {
            System.out.println(user[0] + "," + user[1] + "," + user[2]);
        }
    }

    //多表关联查询,返回一个Page对象,没有实现分页
    @Test
    public void getAllUserForObject2() {
        Page<Object[]> users = userService.getAllUserForObject2();
        for (Object[] user : users) {
            System.out.println(user[0] + "," + user[1] + "," + user[2]);
        }
    }

    //分页查询, 没有动态sql 局限:返回单个实体集合, 不能自定义结果集, 不能与其他表关联查询
    @Test
    public void getPageUserBy() {
        Pageable pageable = new PageRequest(1, 5);
        Page<UserInfo> datas = userInfoRepository.findAll(pageable);

        System.out.println("总条数：" + datas.getTotalElements());
        System.out.println("总页数：" + datas.getTotalPages());
        for (UserInfo user : datas) {
            System.out.println(user);
        }
    }

    //动态sql拼接 分页查询 局限:返回单个实体集合, 不能自定义结果集, 不能与其他表关联查询
    @Test
    public void getPageUserByDynamic() {
        Page<UserInfo> pages = userService.getPageUserByDynamic(null, 1, 4);
        System.out.println("总条数：" + pages.getTotalElements());
        System.out.println("总页数：" + pages.getTotalPages());
        List<UserInfo> list = pages.getContent();
        for (UserInfo user : pages) {
            System.out.println(user);
        }
    }

    // 多表关联查询 动态sql拼接 缺陷:未分页
    @Test
    public void testDynamicSQL() {
        List<Object[]> list = userService.dynamicSQL();
        for (Object[] user : list) {
            System.out.println(user[0] + "," + user[1] + "," + user[2]);
        }
    }

    // 多表关联查询 动态sql拼接 分页
    @Test
    public void testDynamicSQL2() {
        PageTool pageTool = userService.dynamicSQL2(1,2);
        for (Object user : pageTool.getPageData()) {
            System.out.println(user);
        }
    }
}
