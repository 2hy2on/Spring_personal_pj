package com.spring.spring_personal_pj.exception.base;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException{
    ErrorCode errorCode;
    String message;
    HttpStatus httpStatus;
    Map<String, String> data;


    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }
    public BaseException(ErrorCode errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = errorCode.getHttpStatus();
    }


    public BaseException(ErrorCode errorCode, Map<String, String> data) {
        super();
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
        this.data = data;
    }
}
