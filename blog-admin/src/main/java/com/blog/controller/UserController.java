package com.blog.controller;

import com.blog.services.SysUserService;
import com.blog.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private SysUserService sysUserService;


    @GetMapping("/currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return sysUserService.getUserInfoByToken(token);
    }

}
