package com.sudal.home.domain.category.service;

import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.entity.Category;

import java.util.ArrayList;

public interface CategoryService {

    Integer insert(CategoryDto categoryDto);
    ArrayList<Category> selectAll();
    Category selectByCategory(CategoryDto categoryDto);
}
