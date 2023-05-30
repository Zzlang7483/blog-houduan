package com.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.dao.Archives;
import com.blog.dao.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<Article> hotArticles(int limit);

    List<Article> newArticle(int limit);

    List<Archives> listArchives();
}
