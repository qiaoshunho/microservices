package com.ultra.springbootv1;

import com.ultra.springbootv1.repository.RoleInfoRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoleInfo {

    @Autowired
    private RoleInfoRepository roleInfoRepository;
}
