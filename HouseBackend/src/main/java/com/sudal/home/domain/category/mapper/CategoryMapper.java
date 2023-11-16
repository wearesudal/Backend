package com.sudal.home.domain.category.mapper;

import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CategoryMapper {

    Integer insert(String category);
    ArrayList<Category> selectAll();
    Category selectByCategory(CategoryDto categoryDto);
}
