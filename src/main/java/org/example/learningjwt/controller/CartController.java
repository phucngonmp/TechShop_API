package org.example.learningjwt.controller;

import org.example.learningjwt.dto.response.ApiResponse;
import org.example.learningjwt.enums.StatusCode;
import org.example.learningjwt.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public ApiResponse getCart(@PathVariable Long userId){
        return new ApiResponse<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), cartService.getCart(userId));
    }
}
