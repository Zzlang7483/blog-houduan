package com.blog.services;


import com.blog.vo.ArticleVo;
import com.blog.vo.Result;
import com.blog.vo.params.ArticleParam;
import com.blog.vo.params.PageParams;
import com.sun.mail.imap.ResyncData;


import java.util.List;


public interface ArticleService {

    Result listArticlesPage(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    ArticleVo findArticleById(long id);

    Result publish(ArticleParam articleParam);
}

