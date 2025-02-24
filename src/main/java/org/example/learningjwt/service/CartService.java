package org.example.learningjwt.service;

import org.example.learningjwt.dto.CartDTO;
import org.example.learningjwt.entity.Cart;
import org.example.learningjwt.entity.User;
import org.example.learningjwt.mapper.CartMapper;
import org.example.learningjwt.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }
    public CartDTO getCart(Long userId){
        Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new RuntimeException("Cart not found"));
        return cartMapper.toCartDTO(cart);
    }
    public void createNewCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }
}
