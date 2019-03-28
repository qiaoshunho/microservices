package com.ultra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc: 管理员用户表
 * @Author: ZhaoJP
 * @Date: 2019/03/14
 */

public class Admins implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    //用户名
    private String name;

    //密码
    private String password;

    //头像
    private String avatr;

    //登录次数
    private Integer loginCount = 0;

    //创建时的ip
    private String createIp;

    //最后登录ip
    private String lastLoginIp;

    //状态
    private Byte status;

    //创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//是前后到后台的时间格式的转换
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//是后台到前台的时间格式的转换
    private Date createdAt;

    private String createdAtStr;

    //修改时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//数据库导出页面时json格式化
    private Date updatedAt;

    private String updatedAtStr;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatr() {
        return avatr;
    }

    public void setAvatr(String avatr) {
        this.avatr = avatr;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAtStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (getCreatedAt() != null) {
            createdAtStr = sdf.format(getCreatedAt());
        }
        return createdAtStr;
    }

    public void setCreatedAtStr(String createdAtStr) {
        this.createdAtStr = createdAtStr;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAtStr() {
        return updatedAtStr;
    }

    public void setUpdatedAtStr(String updatedAtStr) {
        this.updatedAtStr = updatedAtStr;
    }
}
