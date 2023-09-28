package com.spring.spring_personal_pj.user.entity;

import com.spring.spring_personal_pj.user.dto.FriendDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.awt.Stroke;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "friend")
@NoArgsConstructor
public class FriendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "friend_id")
    private Long friendId;

    @Column(name = "profile_check_status", columnDefinition = "TINYINT(1)")
    private boolean isProfileChecked;

    @Column(name = "is_hidden", columnDefinition = "TINYINT(1)")
    private boolean isHidden;

    @Column(name = "is_blocked", columnDefinition = "TINYINT(1)")
    private boolean isBlocked;

    @Column(name = "is_favorite", columnDefinition = "TINYINT(1)")
    private boolean isFavorite;

    @Column(name = "friend_name")
    private String friendName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "friend_user_id")
    private UserEntity friendUser;

    @Builder
    public FriendEntity(boolean isProfileChecked, boolean isHidden, boolean isBlocked, boolean isFavorite, String friendName, UserEntity user, UserEntity friendUser) {
        this.isProfileChecked = isProfileChecked;
        this.isHidden = isHidden;
        this.isBlocked = isBlocked;
        this.isFavorite = isFavorite;
        this.friendName = friendName;
        this.user = user;
        this.friendUser = friendUser;
    }
}
