package org.example.learningjwt.controller;

import org.example.learningjwt.dto.response.ApiResponse;
import org.example.learningjwt.enums.StatusCode;
import org.example.learningjwt.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public abstract class BaseRestController<D, E> {
    protected final BaseService<D, E> baseService;

    protected BaseRestController(BaseService<D, E> baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> getAll(){
        return new ApiResponse<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), baseService.getAll());
    };

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> create(@RequestBody D dto){
        return new ApiResponse<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), baseService.save(dto));
    };


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> update(@PathVariable Long id, @RequestBody D dto){
        baseService.update(id, dto);
        return new ApiResponse<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), baseService.getById(id));
    };

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> delete(@PathVariable Long id){
        baseService.delete(id);
        return new ApiResponse<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), null);
    };
}
