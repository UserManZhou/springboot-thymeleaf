package com.springboot.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
@Slf4j
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE,reason = "数量过于庞大")
public class CustomException extends RuntimeException{

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public String responseStatusException(Exception e){
        log.error(e.toString());
        return "login";
    }

    //    @ExceptionHandler(value = {NullPointerException.class,ArithmeticException.class})
//    public String customException(){
//
//        return "login";
//    }
}
