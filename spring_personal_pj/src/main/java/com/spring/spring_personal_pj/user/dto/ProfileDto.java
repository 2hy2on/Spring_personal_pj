package com.spring.spring_personal_pj.user.dto;

import com.spring.spring_personal_pj.user.entity.BgImageEntity;
import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDto {
    private Long userId;

    private Long profileId;
    private String nickname;
    private String statusMsg;
    private boolean isMulti;

    private String profileQr;

    private Long profileImgId;
    private boolean isCurrent;

    private String profileImg;

    private Long bgImgId;
    private String bgImg;

    private boolean isBgCurrent;

    @Builder
    public ProfileDto(ProfileEntity p, ProfileImageEntity img, BgImageEntity bg) {
        this.userId = p.getUser().getUserId();
        this.profileId = p.getProfileId();
        this.nickname = p.getNickname();
        this.statusMsg = p.getStatusMsg();
        this.isMulti = p.isMulti();
        this.profileQr = p.getProfileQr();
        //프사
        this.profileImgId = img.getId();
        this.profileImg = img.getProfImg();
        this.isCurrent = img.isCurrent();
        //배사
        this.bgImgId = bg.getBgImgId();
        this.bgImg = bg.getBgImage();
        this.isBgCurrent = bg.isCurrent();
    }
    @Builder
    public ProfileDto(ProfileEntity p) {
        this.userId = p.getUser().getUserId();
        this.profileId = p.getProfileId();
        this.nickname = p.getNickname();
        this.statusMsg = p.getStatusMsg();
        this.isMulti = p.isMulti();
        this.profileQr = p.getProfileQr();
    }
}
