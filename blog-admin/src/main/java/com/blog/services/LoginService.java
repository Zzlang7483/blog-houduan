package com.blog.services;

import com.blog.dao.SysUser;
import com.blog.vo.LoginParam;
import com.blog.vo.Result;

public interface LoginService {

    Result login(LoginParam loginParam);

    public Result logout(String token);
    SysUser checkToken(String token);


    public Result register(LoginParam loginParam);
}
