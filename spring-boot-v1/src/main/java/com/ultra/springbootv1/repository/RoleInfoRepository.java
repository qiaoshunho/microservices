package com.ultra.springbootv1.repository;

import com.ultra.springbootv1.model.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/17
 */
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {
}
