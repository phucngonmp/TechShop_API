package org.example.learningjwt.service;

import org.example.learningjwt.dto.ProductDTO;
import org.example.learningjwt.entity.Product;
import org.example.learningjwt.mapper.ProductMapper;
import org.example.learningjwt.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<ProductDTO, Product> {

    protected ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        super(productRepository, productMapper);
    }
}
