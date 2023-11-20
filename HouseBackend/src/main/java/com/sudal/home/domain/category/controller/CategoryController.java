package com.sudal.home.domain.category.controller;

import com.sudal.home.common.GeneralResponse;
import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse> insert(@RequestBody CategoryDto categoryDto) {
        categoryService.insert(categoryDto);
        return GeneralResponse.successWithoutData(HttpStatus.CREATED,"카테고리 입력 성공");
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse> selectAll() {
        return GeneralResponse.success(HttpStatus.OK,categoryService.selectAll(), "카테고리 조회 성공");
    }

    @GetMapping("/search")
    public ResponseEntity<GeneralResponse> selectByCategory(@RequestParam CategoryDto category) {
        return GeneralResponse.success(HttpStatus.OK,categoryService.selectByCategory(category), "카테고리 검색 성공");
    }
}
