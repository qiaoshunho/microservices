/*
package com.ultra.springbootv1.model;

import javax.persistence.*;

*/
/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/19
 *//*

@Entity
@Table(name = "boot_test", schema = "duty")
public class TestTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = false, nullable = false)
    private Long id; //ID

    @Column(name = "name", length = 16)
    private String name; //姓名

    public TestTable() {
    }

    public TestTable(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
*/
