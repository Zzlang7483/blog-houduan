package com.blog.services;

import com.blog.dao.Tag;
import com.blog.vo.TagVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TagService {
    List<TagVo> findTagsByArticleId(Long id);

    List<TagVo> hot(Integer limit);

}
