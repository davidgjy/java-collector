package com.genesis.springbootarch.domain.data;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:30 PM 2019/4/13
 * @modified by:
 */

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("-- Person Info --\n  Name: %s\n  Age: %d", name, age);
    }
}
