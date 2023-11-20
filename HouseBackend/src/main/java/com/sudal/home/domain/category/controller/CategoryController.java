package com.sudal.home.domain.category.controller;

import com.sudal.home.common.ResponseCode;
import com.sudal.home.common.GeneralResponse;
import com.sudal.home.domain.category.dto.CategoryDto;
import com.sudal.home.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
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
        return GeneralResponse.successWithoutData(ResponseCode.CATEGORY_CREATED);
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse> selectAll() {
        return GeneralResponse.success(ResponseCode.CATEGORY_LOOKUP_SUCCESS, categoryService.selectAll());
    }

    @GetMapping("/search")
    public ResponseEntity<GeneralResponse> selectByCategory(@RequestParam CategoryDto category) {
        return GeneralResponse.success(ResponseCode.CATEGORY_LOOKUP_SUCCESS,categoryService.selectByCategory(category));
    }
}
