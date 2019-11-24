package com.genesis.defaultmemsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class DefaultMemSecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testBcrypt() {

        //加密对象
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        String password = "123456";  //用户密码
        //循环5次
        for (int i = 0; i < 5; i++) {
            //每次密码都不一样
            String encodePassword = passwordEncoder.encode(password);


            System.out.println(encodePassword);
            //但是效验是通过的
            System.out.println(passwordEncoder.matches(password, encodePassword));
        }

    }
}
