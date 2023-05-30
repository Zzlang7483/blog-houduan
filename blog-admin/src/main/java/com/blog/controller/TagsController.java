package com.blog.controller;

import com.blog.services.TagService;
import com.blog.vo.Result;
import com.blog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagsController {

    /**
     *      最热标签
     *
     */
    @Autowired
    private TagService tagService;

    @GetMapping("/hot")
    public Result hotTags(){
        int limit  = 4;
        List<TagVo> hot = tagService.hot(limit);
        return Result.success(hot);
    }

}
