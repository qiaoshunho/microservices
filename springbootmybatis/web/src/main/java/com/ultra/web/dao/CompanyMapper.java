package com.ultra.web.dao;

import com.ultra.web.model.Company;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMapper {

    /*
     * 根据公司id查询公司信息
     */
    @Select("SELECT * FROM company WHERE id = #{id}")
    @Results({
            @Result(property = "companyName",  column = "name")
    })
    Company getCompanyById(Long id);



    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}