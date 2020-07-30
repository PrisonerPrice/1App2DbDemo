package com.prisonerprice.oneAppTwoDbDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int mysqlId;

    @org.springframework.data.annotation.Id
    private String mangoId;

    private String name;

    public User() { }

    public User(String name) {
        this.name = name;
    }

    public User(int mysqlId, String mangoId, String name) {
        this.mysqlId = mysqlId;
        this.mangoId = mangoId;
        this.name = name;
    }

    public int getMysqlId() {
        return mysqlId;
    }

    public void setMysqlId(int mysqlId) {
        this.mysqlId = mysqlId;
    }

    public String getMangoId() {
        return mangoId;
    }

    public void setMangoId(String mangoId) {
        this.mangoId = mangoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "mysqlId=" + mysqlId +
                ", mangoId='" + mangoId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
