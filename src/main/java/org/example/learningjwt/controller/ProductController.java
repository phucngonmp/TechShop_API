package org.example.learningjwt.controller;

import org.example.learningjwt.dto.ApiResponse;
import org.example.learningjwt.dto.request.ProductRequest;
import org.example.learningjwt.mapper.ProductMapper;
import org.example.learningjwt.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController extends RestfulController<ProductRequest> {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public ApiResponse<?> get() {
        return new ApiResponse<>(200, "ok", productService.getAll());
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse<?> create(ProductRequest createRequest) {
       SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .forEach(grantedAuthority -> System.out.println(grantedAuthority.getAuthority()));
        return new ApiResponse<>(200, "ok", productService.save(productMapper.toProduct(createRequest)));
    }

    @Override
    public ApiResponse<?> update(Long id, ProductRequest updateRequest) {
        return new ApiResponse<>(200, "ok", productService.update(id, productMapper.toProduct(updateRequest)));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse<?> delete(Long id) {
        productService.delete(id);
        return new ApiResponse<>(200, "ok", null);
    }
}
