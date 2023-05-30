package com.blog.services;

import com.blog.vo.LoginParam;
import com.blog.vo.Result;

public interface LoginService {

    Result login(LoginParam loginParam);

}
