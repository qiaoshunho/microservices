package com.ultra.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultra.model.Admins;
import com.ultra.web.dao.AdminDao;
import com.ultra.web.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/3/19
 */
@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public int insert(Admins admins) {
        return adminDao.insert(admins);
    }

    @Override
    public PageInfo<Admins> findAllUser(int pageNum, int pageSize) {

        //将参数传给这个方法就可实现物理分页.
        PageHelper.startPage(pageNum, pageSize);
        List<Admins> adminsList = adminDao.selectAdmins();
        PageInfo result = new PageInfo(adminsList);
        return result;
    }
}
