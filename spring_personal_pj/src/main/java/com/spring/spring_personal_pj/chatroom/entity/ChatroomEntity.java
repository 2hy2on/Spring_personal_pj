package com.spring.spring_personal_pj.chatroom.entity;

import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "chatroom")
public class ChatroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chatroom_id")
    private Long chatroomId;

    @Column(name = "is_alarm")
    private boolean isAlarm;

    private String name;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "created_date")
    private LocalDate createDate;

    @Column(name = "unread_msg")
    private String unreadMsg;

    @Column(name = "type")
    private String type;

    @Column(name = "is_favorite")
    private boolean isFavorite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
