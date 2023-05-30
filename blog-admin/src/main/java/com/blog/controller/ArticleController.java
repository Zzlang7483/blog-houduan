package com.blog.controller;

import com.blog.services.ArticleService;
import com.blog.vo.ArticleVo;
import com.blog.vo.Result;
import com.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result articles(@RequestBody PageParams pageParams){
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);
        return Result.success(articles);
    }

    @PostMapping("/hot")
    public Result hotArticle(){
        int limit = 4;
        return   articleService.hotArticle(limit);
    }

    @PostMapping("/new")
    public Result newArticle(){
        int limit = 4;
        return articleService.newArticle(limit);
    }

    @PostMapping("/listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

}
