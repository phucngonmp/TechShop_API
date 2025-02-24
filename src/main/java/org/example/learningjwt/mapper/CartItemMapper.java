package org.example.learningjwt.mapper;

import org.example.learningjwt.dto.CartItemDTO;
import org.example.learningjwt.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartItemMapper extends BaseMapper<CartItemDTO, CartItem> {
    @Mapping(target = "productDTO", source = "product")
    CartItemDTO toDto(CartItem entity);
    CartItem toEntity(CartItemDTO dto);
    void update(@MappingTarget CartItem target, CartItemDTO dto);
}
