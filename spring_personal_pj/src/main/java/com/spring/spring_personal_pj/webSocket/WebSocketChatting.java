package com.spring.spring_personal_pj.webSocket;

import com.spring.spring_personal_pj.chatroom.entity.ChatroomEntity;
import com.spring.spring_personal_pj.chatroom.repository.ChatroomRepository;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ServerEndpoint(value = "/chat/{roomId}")
@Service
public class WebSocketChatting {

    @Autowired
    ChatroomRepository chatroomRepository;
    private static Map<Long, Set<Session>> CLIENTS = Collections.synchronizedMap(new HashMap<>());

    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") Long roomId) {
        System.out.println(session.toString());

        if (roomId != null) {
            Set<Session> s = CLIENTS.computeIfAbsent(roomId, k -> new HashSet<>());
            System.out.println(s+"==========================");
            Set<Session> roomSessions = CLIENTS.get(roomId);
            if (roomSessions.contains(session)) {
                System.out.println("이미 연결된 세션입니다. >" + session);
            } else {
                roomSessions.add(session);
                System.out.println("새로운 세션입니다. >" + session);
            }
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("roomId") Long roomId) {
        Set<Session> roomSessions = CLIENTS.get(roomId);
        if (roomSessions != null) {
            roomSessions.remove(session);
            System.out.println("세션을 닫습니다.: " + session);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("roomId") Long roomId) throws IOException {
        System.out.println("입력된 메세지입니다. >" + message);

        Set<Session> roomSessions = CLIENTS.get(roomId);
        if (roomSessions != null) {
            for (Session client : roomSessions) {
                System.out.println("메세지를 전달합니다. > " + message);
                //db에 저장
                //userId rooomId, Msg dto 객체 .save()
                client.getBasicRemote().sendText(message);
            }
        }
    }
}