package com.ultra.springbootv1.service;

import com.ultra.springbootv1.common.page.PageTool;
import com.ultra.springbootv1.model.master.UserInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description:
 * @Author: ZhaoJP
 * @Date: 2018/12/14
 */
public interface UserService {

    /**
     * 增加一个对象
     * @param userInfo
     * @return
     */
    UserInfo addUserInfo(UserInfo userInfo);

    /**
     * 查找所有用户
     * @return
     */
    List<UserInfo> getAllUserList();

    /**
     * 根据用户名查找
     * @param name
     * @return
     */
    UserInfo getUserByName(String name);

    /**
     * 根据用户名查找-缓存
     * @param name
     * @return
     */
    UserInfo getUserByNameByCache(String name);

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    UserInfo updateUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param Id
     */
    void deleteUserInfoById(Long Id);

    /**
     * 第一种复杂分页查询
     * @return
     */
    Page<UserInfo> getPageUserByDynamic(Long id, int pageNum, int pageSize);

    /**
     * 方式一
     * @return 返回List
     */
    List<Object[]> getAllUserForObject();

    /**
     * 方式二
     * @return 返回Page
     */
    Page<Object[]> getAllUserForObject2();

    /**
     * 方式一 动态拼接sql
     * @return
     */
    List<Object[]> dynamicSQL();

    /**
     * 方式二 动态拼接sql
     * @return
     */
    PageTool dynamicSQL2(Integer page, Integer pageSize);
}
