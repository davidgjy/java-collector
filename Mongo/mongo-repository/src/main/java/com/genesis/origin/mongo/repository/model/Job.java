package com.genesis.origin.mongo.repository.model;

import org.springframework.data.annotation.Id;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 上午11:21 2018/3/7
 * @Modified by:
 */

public class Job {
    @Id
    private String id;
    private String position;
    private String detailLink;
    private String company;
    private String location;
    private String salary;
    private String deployDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(String deployDate) {
        this.deployDate = deployDate;
    }

    @Override
    public String toString() {
        return "Job {" + "id=" + id + ", position=" + position + ", company="
                + company + ", salary=" + salary + ", location=" + location + "}";
    }
}

