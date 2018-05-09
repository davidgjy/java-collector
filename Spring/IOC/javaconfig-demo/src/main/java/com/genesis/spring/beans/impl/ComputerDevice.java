package com.genesis.spring.beans.impl;

import com.genesis.spring.beans.Device;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:48 2018/5/9
 * @modified by:
 */

public class ComputerDevice implements Device {
    @Override
    public void save() {
        System.out.println("Save to computer device...");
    }
}
