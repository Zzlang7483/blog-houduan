package com.blog.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.dao.Archives;
import com.blog.dao.Article;
import com.blog.dao.SysUser;
import com.blog.mapper.ArticleMapper;
import com.blog.services.ArticleService;
import com.blog.services.SysUserService;
import com.blog.services.TagService;
import com.blog.vo.ArticleVo;
import com.blog.vo.Result;
import com.blog.vo.TagVo;
import com.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TagService tagService;
    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticleVo> articleVoList = copyList(articlePage.getRecords(),true,false,true);
        return articleVoList;
    }

    @Override
    public Result hotArticle(int limit) {
        List<Article> articles = articleMapper.hotArticles(limit);
        List<ArticleVo> articleVos = copyList(articles,false,false);
        return Result.success(articleVos);
    }

    @Override
    public Result newArticle(int limit) {
        List<Article> articles = articleMapper.newArticle(limit);
        List<ArticleVo> articleVos = copyList(articles,false,false);
        return Result.success(articleVos);
    }

    @Override
    public Result listArchives() {
        List<Archives> archives = articleMapper.listArchives();
        return Result.success(archives);
    }


    public ArticleVo copy(Article article,Boolean isAuthor , Boolean isBody , Boolean isTags){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        if(isAuthor){
            SysUser sysUser = sysUserService.findUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if(isTags){
            List<TagVo>  tagVos = tagService.findTagsByArticleId(article.getId());
            articleVo.setTags(tagVos);
        }
        return articleVo;
    }

    public List<ArticleVo> copyList(List<Article> articles , boolean isAuthor,boolean isBody,boolean isTags){
        List<ArticleVo> articleVos = new ArrayList<>();
        for (Article article : articles){
            articleVos.add(copy(article,isAuthor,isBody,isTags));
        }
        return articleVos;
    }
    private List<ArticleVo> copyList(List<Article> articles, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : articles) {
            articleVoList.add(copy(record,isTag,isAuthor,false));
        }
        return articleVoList;
    }

}
