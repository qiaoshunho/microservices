package com.ouimeet.laravel.common.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/3/19
 */
public class MySQL5InnoDBDialectUtf8mb4 extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci";
    }
}
