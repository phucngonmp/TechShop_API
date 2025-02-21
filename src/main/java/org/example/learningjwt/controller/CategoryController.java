package org.example.learningjwt.controller;

import org.example.learningjwt.dto.CategoryDTO;
import org.example.learningjwt.dto.response.ApiResponse;
import org.example.learningjwt.entity.Category;
import org.example.learningjwt.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseRestController<CategoryDTO, Category>{

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
