package com.prisonerprice.oneAppTwoDbDemo.entity.sql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SqlUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    public SqlUser() {
    }

    public SqlUser(String name) {
        this.name = name;
    }

    public SqlUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SQLUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}