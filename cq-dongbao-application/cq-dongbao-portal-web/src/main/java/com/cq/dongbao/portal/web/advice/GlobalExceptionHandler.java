package com.cq.dongbao.portal.web.advice;

import com.cq.dongbao.common.result.ResultWarpper;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWarpper commonException(){
        return ResultWarpper.builder().code(333).message("common error").build();
    }
}
