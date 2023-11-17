package com.sudal.home.domain.category.service;

import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.entity.Category;
import com.sudal.home.domain.category.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public Integer insert(CategoryDto categoryDto) {
        return categoryMapper.insert(categoryDto.getCategory());
    }

    @Override
    public ArrayList<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category selectByCategory(CategoryDto categoryDto) {
        return categoryMapper.selectByCategory(categoryDto);
    }
}
