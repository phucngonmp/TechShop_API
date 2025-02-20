package org.example.learningjwt.mapper;

import org.example.learningjwt.dto.ProductDTO;
import org.example.learningjwt.dto.request.ProductRequest;
import org.example.learningjwt.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    void updateProduct(@MappingTarget Product product, ProductDTO productDTO);
    Product toProduct(ProductRequest productRequest);
    Product toProduct(ProductDTO productDTO);
}
