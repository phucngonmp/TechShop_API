package org.example.learningjwt.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ProductDTO {
    private String name;
    private double price;
    private String description;
}
