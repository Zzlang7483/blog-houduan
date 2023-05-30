package com.blog.services;

import com.blog.dao.SysUser;
import com.blog.vo.Result;
import org.springframework.stereotype.Service;


public interface SysUserService {


    SysUser findUserById(Long userId);

    SysUser findUser(String account , String pwd);

    Result getUserInfoByToken(String token);
}
