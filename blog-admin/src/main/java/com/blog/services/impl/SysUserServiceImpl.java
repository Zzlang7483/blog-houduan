package com.blog.services.impl;

import com.blog.dao.SysUser;
import com.blog.mapper.SysUserMapper;
import com.blog.services.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private  SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(Long userId) {
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("city");
        }
        return sysUser;
    }
}
