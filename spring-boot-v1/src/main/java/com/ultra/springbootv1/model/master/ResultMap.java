package com.ultra.springbootv1.model.master;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/20
 */
public class ResultMap {
    String name;
    String jobNumber;
    String roleName;

    public ResultMap() {
    }

    public ResultMap(String name, String jobNumber, String roleName) {
        this.name = name;
        this.jobNumber = jobNumber;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "ResultMap{" +
                "name='" + name + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
