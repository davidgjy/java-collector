package com.genesis.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:57 2018/5/9
 * @modified by:
 */

public class MediaService {
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void save() {
        this.device.save();
    }
}

