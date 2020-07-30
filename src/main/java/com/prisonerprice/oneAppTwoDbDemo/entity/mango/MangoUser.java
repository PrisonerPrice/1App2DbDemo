package com.prisonerprice.oneAppTwoDbDemo.entity.mango;

import org.springframework.data.annotation.Id;

public class MangoUser {

    @Id
    private String id;

    private String name;

    public MangoUser() {
    }

    public MangoUser(String name) {
        this.name = name;
    }

    public MangoUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "MangoUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
