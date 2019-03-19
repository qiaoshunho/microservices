package com.ouimeet.laravel.service.impl;

import com.ouimeet.laravel.model.primary.Shop;
import com.ouimeet.laravel.repository.primary.ShopRepository;
import com.ouimeet.laravel.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/03/15
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }
}
