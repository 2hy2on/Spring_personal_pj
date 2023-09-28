package com.spring.spring_personal_pj.user.dto;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.StringOrBuilder;
import com.spring.spring_personal_pj.user.entity.FriendEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class FriendDto {
    private Long friendId;
    private boolean isProfileChecked;
    private boolean isHidden;
    private boolean isBlocked;
    private boolean isFavorite;
    private Long userId;
    private Long friendUserId;
    private String friendName;
    private Long profileImgId;
    private String profileImg;
    @Builder
    public FriendDto(FriendEntity fe, ProfileImageEntity profImg){
        this.friendId = fe.getFriendId();
        this.isProfileChecked = fe.isProfileChecked();
        this.isHidden = fe.isHidden();
        this.isBlocked = fe.isBlocked();
        this.isFavorite = fe.isFavorite();
        this.friendUserId = fe.getFriendUser().getUserId();
        this.userId = fe.getUser().getUserId();
        this.friendName = fe.getFriendName();
        this.profileImgId = profImg.getId();
        this.profileImg = profImg.getProfImg();
    }

    @Builder
    public FriendDto(FriendEntity fe){
        this.friendId = fe.getFriendId();
        this.isProfileChecked = fe.isProfileChecked();
        this.isHidden = fe.isHidden();
        this.isBlocked = fe.isBlocked();
        this.isFavorite = fe.isFavorite();
        this.friendUserId = fe.getFriendUser().getUserId();
        this.friendName = fe.getFriendName();
        this.userId = fe.getUser().getUserId();
      }
}
