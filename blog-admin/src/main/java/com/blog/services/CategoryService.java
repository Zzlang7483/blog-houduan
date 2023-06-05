package com.blog.services;

import com.blog.dao.Category;
import com.blog.vo.CategoryVo;
import com.blog.vo.Result;

import java.util.List;

public interface CategoryService {
    CategoryVo findCategoryById(Long id);

    Result findAll();

    Result findAllDetail();

    Result categoriesDetailById(Long id);
}

