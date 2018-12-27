package com.ultra.springbootv1.service.impl;

import com.ultra.springbootv1.model.ResultMap;
import com.ultra.springbootv1.model.UserInfo;
import com.ultra.springbootv1.repository.UserInfoRepository;
import com.ultra.springbootv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: ZhaoJP
 * @Date: 2018/12/14
 */
@Service
public class UserServiceImpl implements UserService{

    private UserInfoRepository userInfoRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserInfo addUserInfo(UserInfo userInfo) {
        UserInfo user = new UserInfo("wangsan1", "10002");
        userInfoRepository.save(user);
        UserInfo user1 = new UserInfo("demo1", "10000");
        userInfoRepository.save(user1);
        return null;
    }

    @Override
    public List<UserInfo> getAllUserList() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo getUserByName(String name) {
        return userInfoRepository.findByUserName(name);
    }

    @Override
    public UserInfo getUserByNameByCache(String name) {
        return userInfoRepository.findByUserNameByCache(name);
    }


    @Override
    @Transactional
    public UserInfo updateUser(UserInfo userInfo) {
        userInfo = userInfoRepository.getOne(1l);
        userInfo.setJobNumber("100866");
        userInfo.setName("aaaaa");
        return userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional
    public void deleteUserInfoById(Long id) {
        userInfoRepository.deleteById(id);
    }

    @Override
    public Page<UserInfo> getPageUserByDynamic(Long id, int pageNum, int pageSize) {
        String name = "a" ;
        Pageable pageable = new PageRequest(pageNum, pageSize, Sort.Direction.DESC, "jobNumber");
        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();

                if (name != null && !"".equals(name)) {
                    predicateList.add(
                            //like：模糊匹配，跟SQL是一样的
                            criteriaBuilder.like(
                                    //user表里面有个String类型的name
                                    root.get("name").as(String.class),
                                    //映射规则
                                    "%" + name + "%"));
                }
                if (id != null && id > 0) {
                    predicateList.add(criteriaBuilder.equal(root.get("id").as(Long.class), id));
                }
                //如果还有参数就在这里添加if判断条件即可

                Predicate[] predicates = new Predicate[predicateList.size()];
                //return criteriaQuery.where(predicateList.toArray(predicates)).getRestriction();
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        };
        return userInfoRepository.findAll(specification, pageable);
    }

    @Override
    public List<Object[]> getAllUserForObject() {
        Pageable pageable = new PageRequest(0, 4);
        return userInfoRepository.getAllUserForObject(1l, pageable);
    }

    @Override
    public Page<Object[]> getAllUserForObject2() {
        Pageable pageable = new PageRequest(0, 4);
        return userInfoRepository.getAllUserForObject2(1l, pageable);
    }

    @Override
    public List<Object[]> dynamicSQL() {
        String sql = " select t1.name, t1.jobnumber, t2.rolename from DUTY.BOOT_USER t1" +
                " left join DUTY.BOOT_ROLE t2 on t1.id = t2.userid " +
                " where 1=1 ";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Object[]> dynamicSQL2() {
        String sql = " select t1.name, t1.jobnumber, t2.rolename from DUTY.BOOT_USER t1" +
                " left join DUTY.BOOT_ROLE t2 on t1.id = t2.userid " +
                " where 1=1 ";
        Query query = entityManager.createNativeQuery(sql).setFirstResult(1).setMaxResults(3);
        List<Object[]> resultList = query.getResultList();
        return resultList;
    }
}
