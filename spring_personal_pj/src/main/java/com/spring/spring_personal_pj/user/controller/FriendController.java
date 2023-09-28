package com.spring.spring_personal_pj.user.controller;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.spring.spring_personal_pj.exception.base.BaseResponse;
import com.spring.spring_personal_pj.user.dto.FriendDto;
import com.spring.spring_personal_pj.user.service.FriendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//requestMapping 필요
public class FriendController {

    @Autowired
    private FriendService friendService;

    //친구 목록 확인
    @GetMapping("/friends/list/{userId}")
    BaseResponse<List<FriendDto>> getFriendList(@PathVariable("userId") Long userId) {
        List<FriendDto> friend = friendService.getAllByUserId(userId);
        return BaseResponse.onSuccess(friend);
    }

    //프로필 설정(숨김 차단 즐겨찾기)
    @PatchMapping("/friends")
    BaseResponse<FriendDto> updateFriend(@RequestBody FriendDto friendDto){
        FriendDto friend = friendService.updateFriend(friendDto);
        return BaseResponse.onSuccess(friend);
    }

    //친구 추가
    //연락처로 추가
    @GetMapping("friends/phone/{userId}")
    BaseResponse<FriendDto> addFriendByPhone(@PathVariable("userId") long userId, @Param("phoneNum") String phoneNum){
        FriendDto friend = friendService.addFriendByPhone(userId, phoneNum);
        return BaseResponse.onSuccess(friend);
    }

    //ID로 추가
    @GetMapping("friends/id/{userId}")
    BaseResponse<FriendDto> addFriendById(@PathVariable("userId") long userId, @Param("id") String id){
        FriendDto friend = friendService.addFriendById(userId, id);
        return BaseResponse.onSuccess(friend);
    }


}
