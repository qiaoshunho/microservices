package com.ouimeet.laravel.model.primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * @desc: 商品实体类
 * @Author: ZhaoJP
 * @Date: 2019/03/15
 */
@Entity
@Table(name = "boot_shop")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ShopPK id;

    @Column(name = "price", columnDefinition = "char(10) default 0", nullable = false)
    private String price;

    @Column(name = "remarks", columnDefinition = "varchar(255) default ''", nullable = false)
    private String remarks;

    @Column(name = "time_shop", columnDefinition = "int(10)", nullable = false)
    private Integer timeShop;

    @Column(name = "type", columnDefinition = "tinyint(5)", nullable = false)
    private byte type;

    @Column(name = "status", columnDefinition = "tinyint(2) default 1", nullable = false)
    private byte status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "purchase_id", columnDefinition = "varchar(50) default ''")
    private String purchaseId;

    @Column(name = "purchase_Price", length= 10)
    private String purchasePrice;

    public ShopPK getId() {
        return id;
    }

    public void setId(ShopPK id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getTimeShop() {
        return timeShop;
    }

    public void setTimeShop(Integer timeShop) {
        this.timeShop = timeShop;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
