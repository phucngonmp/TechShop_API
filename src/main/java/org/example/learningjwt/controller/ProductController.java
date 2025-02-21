package org.example.learningjwt.controller;

import org.example.learningjwt.dto.ProductDTO;
import org.example.learningjwt.dto.response.ApiResponse;
import org.example.learningjwt.entity.Product;
import org.example.learningjwt.mapper.ProductMapper;
import org.example.learningjwt.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController extends BaseRestController<ProductDTO, Product> {

    public ProductController(ProductService productService) {
        super(productService);
    }
}
