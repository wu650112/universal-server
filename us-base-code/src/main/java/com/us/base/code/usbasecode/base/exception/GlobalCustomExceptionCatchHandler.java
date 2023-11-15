package com.us.base.code.usbasecode.base.exception;

import com.us.base.code.usbasecode.base.dao.UsBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局自定义异常捕获
 *
 * @author admin
 */
@ControllerAdvice
@Slf4j
public class GlobalCustomExceptionCatchHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            UsBaseException.class,
            Exception.class
    })
    public ResponseEntity<?> handleCustomException(Exception ex) {
        // 构建自定义的响应体，设置自定义的错误信息
        UsBaseResponse response = new UsBaseResponse();
        if (ex instanceof UsBaseException){
            response.setMessage(ex.getMessage());
            response.setStatus(-1);
            response.setSuccess(false);
            log.error("业务异常：", ex);
        }else {
            response.setMessage("未知异常");
            response.setStatus(-1);
            response.setSuccess(false);
            log.error("未知异常：", ex);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
