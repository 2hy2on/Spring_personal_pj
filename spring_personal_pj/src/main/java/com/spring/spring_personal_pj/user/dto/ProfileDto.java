package com.spring.spring_personal_pj.user.dto;

import com.spring.spring_personal_pj.user.entity.ProfileEntity;
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
    private String nickname;
    private String statusMsg;
    private boolean isMulti;
    private String profileQr;

    public ProfileDto(Long userId, String nickname, String statusMsg, boolean multi, String profileQr) {
        this.userId = userId;
        this.nickname = nickname;
        this.statusMsg = statusMsg;
        this.isMulti = isMulti;
        this.profileQr = profileQr;
    }
    public ProfileDto(String nickname, String statusMsg, boolean multi, String profileQr) {
        this.nickname = nickname;
        this.statusMsg = statusMsg;
        this.isMulti = multi;
        this.profileQr = profileQr;
    }

    @Builder
    public ProfileDto(ProfileEntity p) {
        this.userId = p.getUser().getUserId();
        this.nickname = p.getNickname();
        this.statusMsg = p.getStatusMsg();
        this.isMulti = p.isMulti();
        this.profileQr = p.getProfileQr();
    }
}
