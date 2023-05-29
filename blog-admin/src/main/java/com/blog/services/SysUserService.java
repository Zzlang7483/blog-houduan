package com.blog.services;

import com.blog.dao.SysUser;
import org.springframework.stereotype.Service;


public interface SysUserService {


    SysUser findUserById(Long userId);

}
