package com.ultra.springbootv1.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * @desc: redis集群工具类
 * @Author: ZhaoJP
 * @Date: 2018/12/25
 */
@Component
public class JedisClusterUtil {

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 判断key是否存在
     */
    public boolean hasKey(String key) {
        return jedisCluster.exists(key);
    }

    /**
     * 根据key获取Value
     */
    public String get(String key) {

        return jedisCluster.get(key);
    }


    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String key, String value, int expireTime) {
        jedisCluster.set(key, value);
        jedisCluster.pexpire(key, expireTime);
    }


    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        long o = jedisCluster.del(key);
        System.out.println(o + "...");
    }


    /**
     * 删除所有key的缓存
     */
    public void deleteALl(String key) {

        Set<String> set = jedisCluster.hkeys(key);
        System.out.println("删除的key length " + set.size());
        for (String s : set) {
            System.out.println("删除的key" + key);
            jedisCluster.del(s);
        }
    }
}
