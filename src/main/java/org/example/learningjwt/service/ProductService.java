package org.example.learningjwt.service;

import org.example.learningjwt.dto.ProductDTO;
import org.example.learningjwt.entity.Product;
import org.example.learningjwt.mapper.ProductMapper;
import org.example.learningjwt.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements BaseService<ProductDTO, Product, Long> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO getById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream().map(productMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public ProductDTO update(Long id, Product entity) {
        ProductDTO productDTO = getById(id);
        productMapper.updateProduct(entity, productDTO);
        return productDTO;
    }

    @Override
    public ProductDTO save(Product entity) {
        return productMapper.toDto(productRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
