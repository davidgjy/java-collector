package com.genesis.defaultmemsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : KG
 * description:
 * create date: 11:13 AM 2019/11/24
 * modified by:
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("$2a$10$AQbSYvUGpv5GFQWEyHBtCuJq5I9RXshcVWfAstRsrsohjF5FtxQpi").roles("ADMIN", "USER")
                .and()
                .withUser("kg").password("$2a$10$AQbSYvUGpv5GFQWEyHBtCuJq5I9RXshcVWfAstRsrsohjF5FtxQpi").roles("ADMIN");
    }
}
