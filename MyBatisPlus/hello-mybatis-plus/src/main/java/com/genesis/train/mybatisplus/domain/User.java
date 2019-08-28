package com.genesis.train.mybatisplus.domain;

import lombok.Data;

/**
 * @author: KG
 * @description:
 * @date: Created in 4:15 PM 2019/8/28
 * @modified by:
 */

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
