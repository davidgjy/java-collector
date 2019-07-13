package org.genesis.javacollector.common.domain;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:35 2019/7/13
 * @modified by:
 */

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
        this.id = 0;
        this.name = "0";
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
        return "User [id=" + id + ", name=" + name + "]";
    }
}



