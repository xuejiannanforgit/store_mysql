package cn.ztejjx.memberstore.handler;

import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExtHandler {

   @ExceptionHandler(value= Exception.class)
   ResultUtils handlerException(Exception e, HttpServletRequest request)
   {
       return ResultUtils.fail("服务端出问题了",null);
   }
}
