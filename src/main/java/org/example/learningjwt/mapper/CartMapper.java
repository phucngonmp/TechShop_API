package org.example.learningjwt.mapper;

import org.example.learningjwt.dto.CartDTO;
import org.example.learningjwt.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface CartMapper {
    @Mapping(target = "cartItems", source = "cartItems")
    CartDTO toCartDTO(Cart cart);
}
