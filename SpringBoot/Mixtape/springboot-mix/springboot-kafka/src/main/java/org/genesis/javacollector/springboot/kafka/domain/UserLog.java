package org.genesis.javacollector.springboot.kafka.domain;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:38 AM 2019/7/29
 * @modified by:
 */

public class UserLog {
    private String username;
    private String userid;
    private String state;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}




