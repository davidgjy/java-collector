package org.genesis.javacollector.springcloud.oauth.controller;


import org.genesis.javacollector.springcloud.oauth.dto.BaseResponse;
import org.genesis.javacollector.springcloud.oauth.dto.UserResponse;
import org.genesis.javacollector.springcloud.oauth.entity.User;
import org.genesis.javacollector.springcloud.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: KG
 * @date: 2019/10/9
 * Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> userList() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @GetMapping("/testauthority")
    public String testauthority() {
        return "admin权限可以查看";
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/testrole")
    public String testrole() {
        return "角色ROLE_admin可以查看";
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        User newUser = userRepository.save(user);
        newUser.setRoles(new ArrayList<>());
        UserResponse response = new UserResponse();
        response.setData(newUser);


        return ResponseEntity.ok(response);
    }
}

