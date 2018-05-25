package com.genesis.collector.jackson.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: User
 * @Package com.genesis.collector.jackson.domain
 * @Description: User domain
 * @date 2018/5/25 13:50
 */
public class User {
    private String name;

    //不JSON序列化年龄属性
    @JsonIgnore
    private Integer age;

    //格式化日期属性
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;

    //序列化email属性为mail
    @JsonProperty("mail")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        return String.format("Name: " + getName() + "\nAge: " + getAge() + "\nBirthday: " + sf.format(getBirthday())
            + "\nEmail: " + getEmail() + "\n");
    }
}
