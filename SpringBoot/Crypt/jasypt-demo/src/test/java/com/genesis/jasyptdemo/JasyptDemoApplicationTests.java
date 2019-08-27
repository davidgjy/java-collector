package com.genesis.jasyptdemo;

import com.genesis.jasyptdemo.domain.constants.SaltConstants;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptDemoApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

    @Test
    public void encryptPassword() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword(SaltConstants.MYSQL_SALT);
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("mysql");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
}
