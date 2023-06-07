package com.blog.services;


import com.blog.dao.CommentParam;
import com.blog.vo.Result;

public interface CommentsService {

    Result commentsByArticleId(Long articleId);
    Result comment(CommentParam commentParam);

}
