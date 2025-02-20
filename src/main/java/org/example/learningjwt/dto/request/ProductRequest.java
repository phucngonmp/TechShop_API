package org.example.learningjwt.dto.request;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String name;
    private double price;
    private int quantity;
    private String description;
}
