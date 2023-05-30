package com.blog.services;


import com.blog.vo.ArticleVo;
import com.blog.vo.Result;
import com.blog.vo.params.PageParams;
import com.sun.mail.imap.ResyncData;


import java.util.List;


public interface ArticleService {

    List<ArticleVo> listArticlesPage(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();
}

