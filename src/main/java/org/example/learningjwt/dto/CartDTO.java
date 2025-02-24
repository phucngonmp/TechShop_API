package org.example.learningjwt.dto;

import lombok.Data;
import java.util.List;

@Data
public class CartDTO {
    private List<CartItemDTO> cartItems;
    private double totalPrice;
}
