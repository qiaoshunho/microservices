package com.ouimeet.laravel.model.primary;

import javax.persistence.*;
import javax.print.attribute.IntegerSyntax;
import java.io.Serializable;
import java.util.Date;

/**
 * @desc: 管理员用户表
 * @Author: ZhaoJP
 * @Date: 2019/03/14
 */

@Entity
@Table(name = "boot_admins", indexes = {@Index(name = "admins_status_index", columnList = "status")})
public class Admins implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private Integer id;

    //用户名
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    //密码
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    //头像
    @Column(name = "avatr", length = 128)
    private String avatr;

    //登录次数
    @Column(name = "login_count", columnDefinition = "int default 0", length = 11, nullable = false)
    private Integer login_count = 0;

    //创建时的ip
    @Column(name = "create_ip", length = 128)
    private String create_ip;

    //最后登录ip
    @Column(name = "last_login_ip", length = 128)
    private String last_login_ip;

    //状态
    @Column(name = "status", columnDefinition = "tinyint default 1 comment '状态'", length = 4, nullable = false)
    private Byte status;

    //创建时间
    @Column(name = "created_at", columnDefinition = "timestamp null default null comment '创建时间'")
    private Date created_at;

    //修改时间
    @Column(name = "updated_at", columnDefinition = "timestamp null default null comment '修改时间' ")
    private Date updated_at;

    @Override
    public String toString() {
        return "Admins{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", avatr='" + avatr + '\'' +
                ", login_count=" + login_count +
                ", create_ip='" + create_ip + '\'' +
                ", last_login_ip='" + last_login_ip + '\'' +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
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

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public String getCreate_ip() {
        return create_ip;
    }

    public void setCreate_ip(String create_ip) {
        this.create_ip = create_ip;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
