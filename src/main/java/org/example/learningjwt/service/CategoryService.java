package org.example.learningjwt.service;

import org.example.learningjwt.dto.CategoryDTO;
import org.example.learningjwt.entity.Category;
import org.example.learningjwt.mapper.BaseMapper;
import org.example.learningjwt.mapper.CategoryMapper;
import org.example.learningjwt.repository.BaseRepository;
import org.example.learningjwt.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService extends BaseService<CategoryDTO, Category> {
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        super(categoryRepository, categoryMapper);
    }
}
