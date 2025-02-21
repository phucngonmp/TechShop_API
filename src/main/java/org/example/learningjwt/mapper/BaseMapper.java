package org.example.learningjwt.mapper;


public interface BaseMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
    void update(E target, D dto);
}
