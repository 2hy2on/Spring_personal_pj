package com.spring.spring_personal_pj.exception.base;


import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity onBaseException(BaseException exception){
        System.out.println("Exception Advice에 들어옴");
        return new ResponseEntity<>(BaseResponse.onFailure(exception.getErrorCode().getCode(), exception.getMessage(), exception.getData()), null, exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity onException(Exception exception){
        System.out.println("Exception Advice22222222에 들어옴");
        return new ResponseEntity<>(BaseResponse.onFailure(500, exception.getMessage(),null), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity onValidationException(ValidationException exception){
        System.out.println("Exception Advice333333에 들어옴");
        return new ResponseEntity<>(BaseResponse.onFailure(400, exception.getMessage(),null), null, HttpStatus.BAD_REQUEST);
    }

}
