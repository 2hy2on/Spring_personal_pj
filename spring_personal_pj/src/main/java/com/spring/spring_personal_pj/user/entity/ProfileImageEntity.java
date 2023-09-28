package com.spring.spring_personal_pj.user.entity;

import com.spring.spring_personal_pj.user.dto.ProfileImageDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@Table(name = "profileimage")
@NoArgsConstructor
public class ProfileImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "is_current", columnDefinition = "TINYINT(1)")
    private boolean isCurrent;

    @Column(name = "is_hidden", columnDefinition = "TINYINT(1)")
    private boolean isHidden;

    @Column(name = "prof_img")
    private String profImg;

    @Column(name = "create_date", updatable = false) // 생성 날짜는 업데이트되지 않도록 설정
    @CreatedDate
    private Date createDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    //프로필과 프로필 이미지 연결
    public void setProfile(ProfileEntity profile){
        this.profile =  profile;
        profile.getProfileImgs().add(this);
    }

    @Builder
    public ProfileImageEntity(boolean isCurrent, boolean isHidden, String profImg, ProfileEntity p){
        this.isCurrent = isCurrent;
        this.isHidden = isHidden;
        this.profImg = profImg;
        this.profile = p;
    }

    @Builder
    public ProfileImageEntity(ProfileEntity pe, ProfileImageDto p){
        this.isCurrent = p.isCurrent();
        this.isHidden = p.isHidden();
        this.profImg = p.getProfImg();
        this.profile = pe;

    }
}