package com.spring.spring_personal_pj.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 갖는 생성자 추가
@Getter
public class NewPwDto {

    private String email;
    private String pw;
    private String newPw;
}
