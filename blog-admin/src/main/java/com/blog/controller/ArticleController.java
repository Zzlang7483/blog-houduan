package com.blog.controller;

import com.blog.common.aop.Cache;
import com.blog.services.ArticleService;
import com.blog.vo.ArticleVo;
import com.blog.vo.Result;
import com.blog.vo.params.ArticleParam;
import com.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id") long id){
        ArticleVo articleVo = articleService.findArticleById(id);
        return Result.success(articleVo);
    }
    @PostMapping
    public Result articles(@RequestBody PageParams pageParams){

        return articleService.listArticle(pageParams);
    }



    @PostMapping("/hot")
    @Cache(expire = 5*6*1000,name = "hot_article")
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

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
