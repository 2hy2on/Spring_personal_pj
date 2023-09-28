//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.controller;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.spring.spring_personal_pj.exception.base.BaseResponse;
import com.spring.spring_personal_pj.user.dto.UpdatePasswordDto;
import com.spring.spring_personal_pj.user.dto.UserDto;
import com.spring.spring_personal_pj.user.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;


    //회원가입
    @PostMapping("/users/signup")
    @ResponseBody
    public BaseResponse<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto user= service.save(userDto);
        return BaseResponse.onSuccess(user);
    }

    //개인정보 조회
    @GetMapping("/users/{userId}")
    @ResponseBody
    public BaseResponse<UserDto> getUser(@PathVariable("userId") Long userId) {
        UserDto user = service.getUserById(userId);
        return BaseResponse.onSuccess(user);
    }

    //개인정보 수정
    @PatchMapping({"/users/info/{userId}"})
    public BaseResponse<String> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        boolean updated = service.updateUser(userId, userDto);
        return BaseResponse.onSuccess(null);
    }

    //비밀번호 변경
   @PatchMapping("/users/password")
    public BaseResponse<UserDto> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        UserDto user = service.updatePassword(updatePasswordDto);
        return BaseResponse.onSuccess(user);
    }
}
