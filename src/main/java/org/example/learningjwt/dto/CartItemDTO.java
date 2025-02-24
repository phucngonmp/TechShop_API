package org.example.learningjwt.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private ProductDTO productDTO;
    private int quantity;
}
