package com.ultra.springbootv1;

import com.ultra.springbootv1.model.master.UserInfo;
import com.ultra.springbootv1.model.slave.SlaveUserInfo;
import com.ultra.springbootv1.repository.slave.SlaveUserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/1/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSecDataSource {

    @Autowired
    private SlaveUserInfoRepository slaveUserInfoRepository;

    @Test
    public void addUser() {
        SlaveUserInfo userInfo = new SlaveUserInfo( "张三", "1111111");
        slaveUserInfoRepository.save(userInfo);
    }

    @Test
    public void getUserByName() {
        SlaveUserInfo userInfo = slaveUserInfoRepository.findByUserName("张三");
        System.out.println(userInfo);
    }

}
