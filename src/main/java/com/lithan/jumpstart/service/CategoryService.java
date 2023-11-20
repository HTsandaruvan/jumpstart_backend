package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.payload.request.CreateCategoryRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;

public interface CategoryService {
    BaseResponse<?> saveCategory(String currentUserEmail, CreateCategoryRequest request);
    BaseResponse<?> showCategories();
    BaseResponse<?> showCategories(String orderBy);
    BaseResponse<?> showCategoriesWithProducts(String orderBy);
}
