package com.ultra.springbootv1;

import com.ultra.springbootv1.common.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

/**
 * @desc: redis测试
 * @Author: ZhaoJP
 * @Date: 2018/12/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

/*    @Autowired
    RedisTemplate<String, Object> redisTemplate;*/

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testCluster() {
        jedisCluster.set("userName", "QiaoShunho");
        System.out.println(jedisCluster.get("userName"));
    }

}
