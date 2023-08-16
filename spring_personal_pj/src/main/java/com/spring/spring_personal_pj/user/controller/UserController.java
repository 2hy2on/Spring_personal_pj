//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.controller;

import com.spring.spring_personal_pj.user.dto.UserDto;
import com.spring.spring_personal_pj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

    public UserController() {
    }

    @GetMapping({"/users/info/{userId}"})
    @ResponseBody
    public UserDto getUser(@PathVariable("userId") Long userId) {
        return this.service.getUserById(userId);
    }

    @PatchMapping({"/users/info/{userId}"})
    public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        boolean updated = this.service.updateUser(userId, userDto);
        return updated ? ResponseEntity.ok("User updated successfully") : ResponseEntity.notFound().build();
    }
}
