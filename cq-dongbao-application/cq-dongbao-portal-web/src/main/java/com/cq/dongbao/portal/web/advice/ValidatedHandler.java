package com.cq.dongbao.portal.web.advice;

import com.cq.dongbao.common.result.ResultWarpper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ValidatedHandler extends ResponseEntityExceptionHandler {

    /**
     * 重写参数校验异常，返回的数据
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        StringBuilder sb = new StringBuilder();
        //获取到绑定在字段上的错误信息。
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String defaultMessage = fieldError.getDefaultMessage();
            System.out.println("defaultMessage : "+ defaultMessage);
            sb.append(defaultMessage);
        }
        //重新构造返回实体类
        return new ResponseEntity(ResultWarpper.builder().code(200).message(sb.toString()).build(), HttpStatus.OK);
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
