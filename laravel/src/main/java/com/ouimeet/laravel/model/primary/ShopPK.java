package com.ouimeet.laravel.model.primary;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

/**
 * @desc: 商品实体类(联合主键部分) 涉及联合主键需要多定义此类
 * @Author: ZhaoJP
 * @Date: 2019/03/15
 */
@Embeddable
public class ShopPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Integer id;

    //商品名称
    @Column(name = "goods_name", length = 20, nullable = false)
    private String goodsName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopPK shop = (ShopPK) o;
        return getId().equals(shop.getId()) &&
                getGoodsName().equals(shop.getGoodsName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGoodsName());
    }
}
