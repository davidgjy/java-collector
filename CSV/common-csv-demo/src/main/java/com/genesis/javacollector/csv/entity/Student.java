package com.genesis.javacollector.csv.entity;

import lombok.Data;

/**
 * @author : KG
 * description:
 * create date: 2:18 PM 2019/12/31
 * modified by:
 */
@Data
public class Student {
    private String id;
    private String name;
    private String gender;
    private String major;

    public Student() {

    }

    public Student(String id, String name, String gender, String major) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
    }

    @Override
    public String toString() {
        return id + ',' + name + ',' + gender + ',' + major;
    }
}
