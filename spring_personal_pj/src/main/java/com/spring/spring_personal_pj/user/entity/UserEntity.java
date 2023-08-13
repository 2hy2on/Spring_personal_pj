package com.spring.spring_personal_pj.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name="email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "create_date")
    @CreatedDate
    private Date create_date;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updated_date;



    @Builder
    public UserEntity(String email, String phone, String name, String password, Date birth){
        this.email = email;
        this.phone= phone;
        this.name = name;
        this.password = password;
        this.birth = birth;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("");
//
}
