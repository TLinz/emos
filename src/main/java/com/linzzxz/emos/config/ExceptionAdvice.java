package com.linzzxz.emos.config;

import com.linzzxz.emos.exception.EmosException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// 捕获SpringMVC抛出的所有异常
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // 全局捕获Exception及子类异常
    @ExceptionHandler(Exception.class)
    public String validExceptionHandler(Exception e) {
        log.error("Execution Exception", e);

        // 后端验证失败异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            // 将错误信息返回给前台
            return exception.getBindingResult().getFieldError().getDefaultMessage();
        } else if (e instanceof EmosException) {
            EmosException exception = (EmosException) e;
            return exception.getMsg();
        } else if (e instanceof UnauthorizedException) {
            return "You do not have the required permissions";
        } else {
            return "Backend execution exception";
        }
    }
}


