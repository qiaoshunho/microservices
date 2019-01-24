package com.ultra.springbootv1.model.master;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description: user实体类
 * @Author: ZhaoJP
 * @Date: 2018/12/14
 */
@Entity
@Table(name = "boot_user", schema = "duty")
public class UserInfo implements Serializable{

/*  JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
    TABLE：使用一个特定的数据库表格来保存主键。
    SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    IDENTITY：主键由数据库自动生成（主要是自动增长型）
    AUTO：主键由程序控制。*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = false, nullable = false)
    private Long id; //ID

    @Column(name = "name", length = 16)
    private String name; //姓名

    @Column(name = "jobnumber", length = 32)
    private String jobNumber; //工号

    public UserInfo() {
    }

    public UserInfo(String name, String jobNumber) {
        this.name = name;
        this.jobNumber = jobNumber;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }
}
