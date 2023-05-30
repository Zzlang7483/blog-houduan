package com.blog.handler;

import com.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//对加了@Controller注解的方法进行拦截处理 AOP的实现
@ControllerAdvice
public class AllExceptionHandler{

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception exception){
        exception.printStackTrace();
        return Result.fail(500,"系统异常");
    }
}
