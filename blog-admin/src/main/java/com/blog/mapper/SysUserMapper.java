package com.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.dao.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
