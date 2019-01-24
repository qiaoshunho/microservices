package com.ultra.springbootv1.model.master;

import javax.persistence.*;

/**
 * @desc: 角色信息表
 * @Author: ZhaoJP
 * @Date: 2018/12/14
 */
@Entity
@Table(name = "boot_role", schema = "duty")
public class RoleInfo {

    @Id
    @SequenceGenerator(name="BOOT_SEQ", sequenceName="DUTY.BOOT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator="BOOT_SEQ")
    @Column(name = "id",unique = false, nullable = false)
    private Long id; //ID

    @Column(name = "rolename", length = 16)
    private String roleName; //角色名称

    @Column(name = "userid", length = 16)
    private Long userId; //关联id

    public RoleInfo() {
    }

    public RoleInfo(String roleName, Long userId) {
        this.roleName = roleName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
