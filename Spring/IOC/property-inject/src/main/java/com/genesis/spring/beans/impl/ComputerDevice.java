package com.genesis.spring.beans.impl;

import com.genesis.spring.beans.Device;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:48 2018/5/9
 * @modified by:
 */

@Repository
public class ComputerDevice implements Device {
    @Value("${device.name}")
    private String name;

    @Value("${device.volume}")
    private int volume;

    @Override
    public void save() {

        System.out.println("Save to computer device...");
        System.out.println("Device Name: " + name);
        System.out.println("Device Volume: " + volume);
    }
}
