package com.genesis.spring.beans.impl;

import com.genesis.spring.beans.Device;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:47 2018/5/9
 * @modified by:
 */

@Repository
public class MobileDevice implements Device {
    @Override
    public void save() {
        System.out.println("Save to mobile device...");
    }
}
