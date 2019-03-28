package com.ultra.web.dao;

import com.ultra.web.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /*
     * 一对一查询
     * property：查询结果赋值给此实体属性
     * column：对应数据库的表字段，做为下面@One(select方法的查询参数
     * one：一对一的查询
     * @One(select = 方法全路径) ：调用的方法
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "company", column = "company_id", one = @One(select =
                    "com.ultra.web.dao.CompanyMapper.getCompanyById"))
    })
    User getUserWithCompany(Long id);

    /*
     * 一对多查询
     * property：查询结果赋值给此实体属性
     * column：对应数据库的表字段，可做为下面@One(select方法)的查询参数
     * many：一对多的查询
     * @Many(select = 方法全路径) ：调用的方法
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),//加此行，否则id值为空
            @Result(property = "accounts", column = "id", many = @Many(select =
                    "com.ultra.web.dao.AccountMapper.getAccountByUserId"))
    })
    User getUserWithAccount(Long id);

    /*
     * 同时用一对一、一对多查询
     */
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "company", column = "company_id", one = @One(select =
                    "com.ultra.web.dao.CompanyMapper.getCompanyById")),
            @Result(property = "accounts", column = "id", many = @Many(select =
                    "com.ultra.web.dao.AccountMapper.getAccountByUserId"))
    })
    List<User> getAll();

    List<User> getAllByXml();

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}