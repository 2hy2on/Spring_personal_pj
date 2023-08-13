package com.spring.spring_personal_pj.user.controller;

import com.spring.spring_personal_pj.user.dto.UserDto;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import com.spring.spring_personal_pj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

//    @PostMapping("/users/signup")
//    public @ResponseBody UserDto signup(@RequestBody UserDto userDto) {
//        return service.save(userDto);
//    }

//    @PostMapping("/users/signup")
//    public ResponseEntity<Object> signup(@RequestBody UserDto userDto) {
//        UserDto savedUser = service.save(userDto);
//
//        if (savedUser != null) {
//            return ResponseEntity.ok(savedUser);
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed");
//        }
//    }


    @GetMapping("/users/info/{userId}")
    public @ResponseBody UserDto getUser(@PathVariable("userId") Long userId) {
        return service.getUserById(userId);
    }

    @PatchMapping("/users/info/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        boolean updated = service.updateUser(userId, userDto);

        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
