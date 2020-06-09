package org.genesis.javacollector.springcloud.oauth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author KG
 * @data 2018/11/04 22:30
 */

@Entity
@Data
public class UserRole {
    @Id
    @GeneratedValue
    private long id;
    private String role;
    private String name;

}

