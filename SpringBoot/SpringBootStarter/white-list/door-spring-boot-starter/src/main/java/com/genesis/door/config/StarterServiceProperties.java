package com.genesis.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : KG
 * description : 
 * create date : 2019/12/4 9:29 PM
 * modified by : 
 */

@ConfigurationProperties("genesis.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

}
