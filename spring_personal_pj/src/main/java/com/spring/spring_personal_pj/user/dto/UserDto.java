package com.spring.spring_personal_pj.user.dto;

import com.spring.spring_personal_pj.user.entity.UserEntity;
import jakarta.persistence.Column;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@Builder
@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 갖는 생성자 추가

public class UserDto {

    private String email;
    private String phone;
    private String name;
    private String password;
    private Date birth;

    private String id;

    public UserEntity toEntity(){
        return UserEntity.builder()
            .email(email)
            .phone(phone)
            .name(name)
            .password(password)
            .birth(birth)
            .id(id)
            .build();
    }

    @Builder
    public UserDto(UserEntity userEntity){
        this.email = userEntity.getEmail();
        this.phone = userEntity.getPhone();
        this.name = userEntity.getName();
        this.password = userEntity.getPassword();
        this.birth = userEntity.getBirth();
        this.id = userEntity.getId();
    }
}
