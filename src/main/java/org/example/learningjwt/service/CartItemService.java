package org.example.learningjwt.service;

import org.example.learningjwt.dto.CartItemDTO;
import org.example.learningjwt.entity.CartItem;
import org.example.learningjwt.mapper.BaseMapper;
import org.example.learningjwt.mapper.CartItemMapper;
import org.example.learningjwt.repository.BaseRepository;
import org.example.learningjwt.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService extends BaseService<CartItemDTO, CartItem> {
    protected CartItemService(CartItemRepository cartItemRepository, CartItemMapper cartItemMapper) {
        super(cartItemRepository, cartItemMapper);
    }
}
