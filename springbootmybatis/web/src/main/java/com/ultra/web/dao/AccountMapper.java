package com.ultra.web.dao;

import com.ultra.web.model.Account;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {


    /*
     * 根据用户id查询账户信息
     */
    @Select("SELECT * FROM `account` WHERE user_id = #{userId}")
    @Results({
            @Result(property = "accountName",  column = "name")
    })
    List<Account> getAccountByUserId(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}