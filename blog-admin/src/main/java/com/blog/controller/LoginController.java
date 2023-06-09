package com.blog.controller;

import com.blog.services.LoginService;
import com.blog.vo.LoginParam;
import com.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){

        return loginService.login(loginParam);
    }


}
