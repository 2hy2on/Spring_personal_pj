package com.spring.spring_personal_pj.user.dto;

import com.spring.spring_personal_pj.user.entity.UserEntity;
import jakarta.persistence.Column;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public UserEntity toEntity(){
        return UserEntity.builder()
            .email(email)
            .phone(phone)
            .name(name)
            .password(password)
            .birth(birth)
            .build();
    }

}
