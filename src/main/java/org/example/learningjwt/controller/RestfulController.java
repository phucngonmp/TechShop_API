package org.example.learningjwt.controller;

import org.example.learningjwt.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public abstract class RestfulController<R> {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public abstract ApiResponse<?> get();

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public abstract ApiResponse<?> create(@RequestBody R request);


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public abstract ApiResponse<?> update(@PathVariable Long id, R request);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public abstract ApiResponse<?> delete(@PathVariable Long id);
}
