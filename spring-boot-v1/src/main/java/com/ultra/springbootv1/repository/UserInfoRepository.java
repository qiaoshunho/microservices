package com.ultra.springbootv1.repository;

import com.ultra.springbootv1.model.UserInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc: spring data jpa让我们解脱了DAO层的操作，基本上所有CRUD都可以依赖于它来实现，需要实现JpaRepository接口
 * @Author: ZhaoJP
 * @Date:   2018/12/14
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    @Query("select t from UserInfo t where t.name = :name")
    UserInfo findByUserName(@Param("name") String name);

    @Cacheable(value = "mycache")
    @Query("select t from UserInfo t where t.name = :name")
    UserInfo findByUserNameByCache(@Param("name") String name);

    @Query(value = "select t1.name, t1.jobnumber, t2.rolename\n" +
            "from DUTY.BOOT_USER t1\n" +
            "  left join DUTY.BOOT_ROLE t2 on t1.id = t2.userid\n" +
            " where t1.id = :id", nativeQuery = true)
    List<Object[]> getAllUserForObject(@Param("id")Long id, Pageable pageable);

    @Query(value = "select m.name, m.jobnumber, n.rolename\n" +
            "from DUTY.BOOT_USER m\n" +
            "  left join DUTY.BOOT_ROLE n on m.id = n.userid\n" +
            " where m.id = :id",
            countQuery = "select count(*)" +
                    "from DUTY.BOOT_USER m\n" +
                    "  left join DUTY.BOOT_ROLE n on m.id = n.userid\n" +
                    "where m.id = :id",
            nativeQuery = true)
    Page<Object[]> getAllUserForObject2(@Param("id")Long id, Pageable pageable);

    /**
     * nativeQuery = true
     * 本地查询，就是使用原生的sql语句进行查询数据库的操作,不使用hql类型
     */
/*    @Query(value = "select t1.name, t1.jobnumber, t2.role_name\n" +
            "from DUTY.BOOT_USER t1\n" +
            "  left join DUTY.BOOT_ROLE t2 on t1.id = t2.user_id\n" +
            " where t1.id = :id",
            countQuery = "select count(*)" +
                    "from DUTY.BOOT_USER t1\n" +
                    "  left join DUTY.BOOT_ROLE t2 on t1.id = t2.user_id\n" +
                    "where t1.id = :id"
            , nativeQuery = true)
    Page<Object[]> getPageUserList2(@Param("id")Long id, Pageable pageable);*/

/*
    * 删除  必须加入@Modifying
    * *//*

    @Modifying
    @Transactional
    @Query("delete from User u where u.id=:id")
    public int deleteUserById(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update User u set u.name = :name where u.id=:id")
    public int queryUserById(@Param("id") Integer id,@Param("name") String name);

    @Query(value = "insert into UserInfo value(?,?,?)", nativeQuery = true)
    @Transactional
    @Modifying
    public int countUserBy(@Param("id")Integer id, @Param("name") String name, @Param("password") String password);
*/

}
