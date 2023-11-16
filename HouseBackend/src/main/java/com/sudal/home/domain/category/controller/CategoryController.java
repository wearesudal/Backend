package com.sudal.home.domain.category.controller;

import com.sudal.home.common.GeneralResponse;
import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.entity.Category;
import com.sudal.home.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("")
    public GeneralResponse<Integer> insert(@RequestBody CategoryDto categoryDto) {
        categoryService.insert(categoryDto);
        return GeneralResponse.successWithoutData("카테고리 입력 성공");
    }

    @GetMapping("")
    public GeneralResponse<ArrayList<Category>> selectAll() {
        return GeneralResponse.success(categoryService.selectAll(), "카테고리 조회 성공");
    }

    @GetMapping("/search")
    public GeneralResponse<Category> selectByCategory(@RequestParam CategoryDto category) {
        return GeneralResponse.success(categoryService.selectByCategory(category), "카테고리 검색 성공");
    }
}