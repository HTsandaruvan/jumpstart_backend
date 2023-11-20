package com.lithan.jumpstart.service.impl;

import com.lithan.jumpstart.constraint.ERole;
import com.lithan.jumpstart.entity.Category;
import com.lithan.jumpstart.exception.RefusedActionException;
import com.lithan.jumpstart.payload.request.CreateCategoryRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;
import com.lithan.jumpstart.repository.CategoryRepository;
import com.lithan.jumpstart.repository.UserRepository;
import com.lithan.jumpstart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BaseResponse<?> saveCategory(String currentUserEmail, CreateCategoryRequest request) {
        BaseResponse<Category> response = new BaseResponse<>();
        try {
            if (!userRepository.existsByEmailAndRole(currentUserEmail, ERole.ROLE_ADMIN)) {
                throw new RefusedActionException("Forbidden");
            }
            String categoryName = request.getCategoryName().trim();
            String slug = request.getCategoryName().toLowerCase().trim().replaceAll(" ", "_");
            Category category = categoryRepository.findByCategorySlug(slug);

            if (category == null) {
                category = new Category();
                category.setCategoryName(categoryName);
                category.setCategorySlug(slug);
                categoryRepository.save(category);
                response.setMessage("New category created successfully!");
            } else {
                response.setMessage("Category has been created. Category ID: " + category.getCategoryId());
            }

            response.setCode(200);
            response.setResult(category);
            return response;
        } catch (RefusedActionException e) {
            response.setCode(403);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @Override
    public BaseResponse<?> showCategories() {
        List<Category> categories = categoryRepository.findAll();

        return BaseResponse.ok(categories);
    }

    @Override
    public BaseResponse<?> showCategories(String orderBy) {
        List<Category> categories = new ArrayList<>();
        switch (orderBy) {
            case "asc":
                categories = categoryRepository.findAllByOrderByCategoryNameAsc();
                break;
            case "desc":
                categories = categoryRepository.findAllByOrderByCategoryNameDesc();
                break;
            default:
                categories = categoryRepository.findAll();
        }

        return BaseResponse.ok(categories);
    }

    @Override
    public BaseResponse<?> showCategoriesWithProducts(String orderBy) {
        List<Category> categories = new ArrayList<>();
        switch (orderBy) {
            case "asc":
                categories = categoryRepository.findAllByOrderByCategoryNameAsc();
                break;
            case "desc":
                categories = categoryRepository.findAllByOrderByCategoryNameDesc();
                break;
            default:
                categories = categoryRepository.findAll();
        }

        return BaseResponse.ok(categories);
    }
}
