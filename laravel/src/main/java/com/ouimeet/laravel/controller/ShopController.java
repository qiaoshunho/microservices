package com.ouimeet.laravel.controller;

import com.ouimeet.laravel.model.primary.Shop;
import com.ouimeet.laravel.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @desc: 商品管理列表controller
 * @Author: ZhaoJP
 * @Date: 2019/03/15
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {

    private ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/findAllShops")
    private ModelAndView findAllShops(){
        ModelAndView mv = new ModelAndView();
        List<Shop> shops = shopService.findAllShops();
        mv.setViewName("shopList");
        mv.addObject("shops", shops);
        return mv;
    }

}
