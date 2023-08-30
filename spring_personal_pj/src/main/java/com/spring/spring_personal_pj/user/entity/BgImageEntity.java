package com.spring.spring_personal_pj.user.entity;

import com.spring.spring_personal_pj.user.dto.ProfileDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Table(name = "bgimage")
public class BgImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bg_image_id")
    private Long bgImgId;

    @Column(name = "is_current", columnDefinition = "TINYINT(1)")
    private boolean isCurrent;

    @Column(name = "is_hidden", columnDefinition = "TINYINT(1)")
    private boolean isHidden;

    @Column(name = "bg_image")
    private String bgImage;

    @Column(name = "create_date")
    @CreatedDate
    private Date create_date;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updated_date;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

}
