package com.genesis.spring.config;

import com.genesis.spring.beans.Device;
import com.genesis.spring.beans.MediaService;
import com.genesis.spring.beans.impl.MobileDevice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:42 2018/5/9
 * @modified by:
 */

@Configuration
public class MediaConfig {
    @Bean
    public Device device() {
        return new MobileDevice();
    }

    @Bean
    public MediaService mediaProvider(){
        MediaService media = new MediaService();
        media.setDevice(device());

        return media;
    }
}
