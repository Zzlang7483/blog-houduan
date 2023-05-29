package com.blog.services;


import com.blog.vo.ArticleVo;
import com.blog.vo.params.PageParams;


import java.util.List;


public interface ArticleService {

    List<ArticleVo> listArticlesPage(PageParams pageParams);

}

