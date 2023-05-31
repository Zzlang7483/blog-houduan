package com.blog.controller;

import com.blog.services.LoginService;
import com.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logout")
public class LogoutController {

    @Autowired
    private LoginService loginService;

    @GetMapping("")
    public Result Logpout(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}
