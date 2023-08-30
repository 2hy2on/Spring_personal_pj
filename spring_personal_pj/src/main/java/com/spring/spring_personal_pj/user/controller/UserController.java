//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.controller;

import com.spring.spring_personal_pj.user.dto.NewPwDto;
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

    public UserController() {
    }

    //회원가입
    @PostMapping("/users/signup")
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto){
        return service.save(userDto);
    }

    //개인정보 조회
    @GetMapping({"/users/info/{userId}"})
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable("userId") Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.service.getUserById(userId));
        return  new ResponseEntity<>(map, HttpStatus.OK);
    }

    //개인정보 수정
    @PatchMapping({"/users/info/{userId}"})
    public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        boolean updated = this.service.updateUser(userId, userDto);
        return updated ? ResponseEntity.ok("User updated successfully") : ResponseEntity.notFound().build();
    }

    //비밀번호 변경
   @PatchMapping("/users/password")
    public UserDto updatePassword(@RequestBody NewPwDto newPwDto){
        return service.updatePassword(newPwDto);
   }
}
