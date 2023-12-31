package com.lithan.jumpstart.controller;

import com.lithan.jumpstart.entity.Category;
import com.lithan.jumpstart.payload.response.BaseResponse;
import com.lithan.jumpstart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> showAllCategories(@RequestParam(value = "order", required = false) String orderBy) {
        BaseResponse<?> response = categoryService.showCategories();
        if (orderBy != null) {
            response = categoryService.showCategories(orderBy);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categories/with-products")
    public ResponseEntity<?> showAllCategoriesWithProducts(
            @RequestParam(value = "order", required = false) String orderBy,
            @RequestParam(value = "data", required = false) String data
    ) {
        BaseResponse<?> response = categoryService.showCategories();
        if (orderBy != null) {
            response = categoryService.showCategories(orderBy);
        }
        return ResponseEntity.ok(response);
    }
}
