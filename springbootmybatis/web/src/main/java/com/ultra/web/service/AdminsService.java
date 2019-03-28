package com.ultra.web.service;


import com.github.pagehelper.PageInfo;
import com.ultra.model.Admins;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/3/19
 */
public interface AdminsService {

    int insert(Admins admins);


    PageInfo<Admins> findAllUser(int pageNum, int pageSize);

}
