package com.genesis.door.config;

import org.springframework.util.StringUtils;

/**
 * @author : KG
 * description :
 * create date : 2019/12/4 9:28 PM
 * modified by :
 */

public class StarterService {

    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }

}
