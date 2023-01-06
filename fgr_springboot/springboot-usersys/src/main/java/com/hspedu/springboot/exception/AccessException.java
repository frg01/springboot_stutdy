package com.hspedu.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * AccessException 自定义的异常
 * 发生这个异常 通过http返回的状态码403
 * 状态码和自定义异常的关系是由程序员合理决定
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AccessException extends RuntimeException{

    //构造器 可以指定信息
    public AccessException(String message){
        super(message);
    }

    //显示的定义一下无参构造器
    public AccessException() {
    }
}
