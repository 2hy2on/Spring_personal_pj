package com.spring.spring_personal_pj.chatroom.controller;

import com.spring.spring_personal_pj.chatroom.dto.ChatroomReq;
import com.spring.spring_personal_pj.chatroom.service.ChatroomService;
import com.spring.spring_personal_pj.exception.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class ChatroomController {

    @Autowired
    private ChatroomService chatroomService;

//    @PostMapping("/chatrooms")
//    public BaseResponse<ChatroomReq> addChatroom(@RequestBody ChatroomReq){
//
//        return BaseResponse.onSuccess()
//    }

}
