package com.spring.spring_personal_pj.user.entity;
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
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "profile")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProfileEntity {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Long profileId;
    private String nickname;
    @Column(name = "status_msg")
    private String statusMsg;

    @Column(name = "is_multi", columnDefinition = "TINYINT(1)")
    private boolean isMulti;

    @Column(name = "create_date")
    @CreatedDate
    private Date create_date;
    @Column(name = "update_date")
    @LastModifiedDate
       private Date updated_date;

    @Column(name = "profile_qr")
    private String profileQr;

   @ManyToOne
  @JoinColumn(name = "User_user_id")
    private UserEntity user;


   public void setUser(UserEntity user){
       this.user =  user;
      user.getProfiles().add(this);
    }

    @Builder
    public ProfileEntity (UserEntity user, String nickname, String statusMsg, boolean isMulti, String profileQr ) {
       this.user = user;
       this.nickname = nickname;
        this.statusMsg = statusMsg;
        this.isMulti = isMulti;
        this.profileQr = profileQr;

    }
}


