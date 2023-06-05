package com.blog.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blog.dao.Tag;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.TagMapper;
import com.blog.services.TagService;
import com.blog.vo.Result;
import com.blog.vo.TagVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;


    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        tagVo.setId(String.valueOf(tag.getId()));
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }



    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

    @Override
    public List<TagVo> hot(Integer limit) {
        List<Long> ids =  tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(ids)){
            return Collections.EMPTY_LIST;
        }
        List<Tag> tagsByTagIds = tagMapper.findTagsByTagIds(ids);

        return copyList(tagsByTagIds);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId,Tag::getAvatar,Tag::getTagName);
        List<Tag> tags = this.tagMapper.selectList(queryWrapper);
        List<TagVo> tagVos = copyList(tags);
        log.info("aaaaaa");
        return Result.success(tagVos);
    }

    @Override
    public Result findAllDetail() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        List<Tag> tags = tagMapper.selectList(queryWrapper);
        return Result.success(tags);
    }

    @Override
    public Result findDetailById(Long id) {
        TagVo tagVo = new TagVo();
        Tag tag = tagMapper.selectById(id);
        tagVo  = copy(tag);
        return Result.success(tagVo);
    }
}

