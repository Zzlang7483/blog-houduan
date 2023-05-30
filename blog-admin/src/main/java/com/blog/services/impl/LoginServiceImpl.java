package com.blog.services.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.blog.dao.SysUser;
import com.blog.services.LoginService;
import com.blog.services.SysUserService;
import com.blog.util.JWTUtils;
import com.blog.vo.ErrorCode;
import com.blog.vo.LoginParam;
import com.blog.vo.LoginUserVo;
import com.blog.vo.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String slat = "Zdz!@#";

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate ;

    @Override
    public Result login(LoginParam loginParam) {

        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        String pwd = DigestUtils.md5Hex(password + slat);
        SysUser sysUser = sysUserService.findUser(account,pwd);
        if (sysUser == null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(),ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        //登录成功，使用JWT生成token，返回token和redis中
        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return Result.success(token);
    }



}
