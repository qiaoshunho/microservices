package com.ouimeet.laravel.service;

import com.ouimeet.laravel.model.primary.Shop;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/03/15
 */
public interface ShopService {

    List<Shop> findAllShops();

}
