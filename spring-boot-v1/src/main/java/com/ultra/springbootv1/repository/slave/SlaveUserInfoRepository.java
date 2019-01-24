package com.ultra.springbootv1.repository.slave;

import com.ultra.springbootv1.model.master.UserInfo;
import com.ultra.springbootv1.model.slave.SlaveUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @desc: 第二数据源测试
 * @Author: ZhaoJP
 * @Date:
 */
public interface SlaveUserInfoRepository extends JpaRepository<SlaveUserInfo, Long>, JpaSpecificationExecutor<SlaveUserInfo> {

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    @Query("select t from SlaveUserInfo t where t.name = :name")
    SlaveUserInfo findByUserName(@Param("name") String name);

}
