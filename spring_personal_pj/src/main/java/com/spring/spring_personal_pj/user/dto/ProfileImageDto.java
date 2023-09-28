package com.spring.spring_personal_pj.user.dto;

import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileImageDto {

    private Long profileId;
    private Long imageId;
    private boolean isCurrent;
    private boolean isHidden;
    private String profImg;

    @Builder
    public ProfileImageDto(ProfileImageEntity pe){
        this.imageId = pe.getId();
        this.isCurrent = pe.isCurrent();
        this.isHidden = pe.isHidden();
        this.profImg = pe.getProfImg();
        this.profileId = pe.getProfile().getProfileId();
    }
}
