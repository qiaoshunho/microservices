package com.ultra.web.dao;

import com.ultra.model.Admins;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/3/19
 */
@Repository
public interface AdminDao {


    int insert(Admins admins);

    List<Admins> selectAdmins();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Admins record);

    Admins selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);

}
