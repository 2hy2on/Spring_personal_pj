package com.spring.spring_personal_pj.exception.base;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

import lombok.Getter;


@Getter
public enum ErrorCode {

    SUCCESS(1000, "요청에 성공하였습니다.", OK),

    //Common
    _INTERNAL_SERVER_ERROR(2000, "서버 에러, 관리자에게 문의 바랍니다.", INTERNAL_SERVER_ERROR),
    _BAD_REQUEST(2001, "잘못된 요청입니다.", BAD_REQUEST),

    MEMBER_NOT_FOUND(2008, "해당 유저를 찾을 수 없습니다.", BAD_REQUEST),

    EMAIL_NOT_FOUND(2009, "해당 이메일을 찾을 수 없습니다.", BAD_REQUEST),

    CHECK_PASSWORD_SAME(2010, "변경 전 비밀번호와 같습니다.", BAD_REQUEST);
    private int code;
    private String message;
    private HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
