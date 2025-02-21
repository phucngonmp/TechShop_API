package org.example.learningjwt.mapper;

import org.example.learningjwt.dto.CategoryDTO;
import org.example.learningjwt.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoryDTO, Category> {
    CategoryDTO toDto(Category entity);
    Category toEntity(CategoryDTO dto);
    void update(@MappingTarget Category target, CategoryDTO dto);
}
