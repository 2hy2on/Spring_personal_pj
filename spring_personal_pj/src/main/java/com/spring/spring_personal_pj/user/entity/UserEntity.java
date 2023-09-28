//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.entity;

import com.spring.spring_personal_pj.chatroom.entity.ChatroomEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(
    name = "user"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // Auditing 적용
public class UserEntity {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    @Column(
        name = "user_id"
    )
    private Long userId;
    @Column(
        name = "email"
    )

    private String email;
    @Column(
        name = "id"
    )
    private String id;

    @Column(
        name = "phone"
    )
    private String phone;
    @Column(
        name = "name"
    )
    private String name;
    @Column(
        name = "password"
    )
    private String password;
    @Column(
        name = "birth"
    )
    private Date birth;
    @Column(
        name = "create_date"
    )
    @CreatedDate
    private Date create_date;
    @Column(
        name = "update_date"
    )
    @LastModifiedDate
    private Date updated_date;

    @OneToMany(mappedBy = "user")
    private List<FriendEntity> friendList = new ArrayList<>();

    @OneToMany(mappedBy = "friendUser")
    private List<FriendEntity> friends = new ArrayList<>();
    @OneToMany(mappedBy = "user")
   // @JoinColumn(name = "user")
    private List<ProfileEntity> profiles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ChatroomEntity> chatrooms = new ArrayList<>();
    @Builder
    public UserEntity(String email, String phone, String name, String password, Date birth, String id) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.id = id;
    }

}
