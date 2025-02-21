package org.example.learningjwt.mapper;

import org.example.learningjwt.dto.ProductDTO;
import org.example.learningjwt.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductDTO, Product> {
    ProductDTO toDto(Product entity);
    Product toEntity(ProductDTO dto);
    void update(@MappingTarget Product target, ProductDTO dto);
}
