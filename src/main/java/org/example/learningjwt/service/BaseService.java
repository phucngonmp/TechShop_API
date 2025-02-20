package org.example.learningjwt.service;

import org.example.learningjwt.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, Y, ID> {
    T getById(ID id);
    List<T> getAll();
    T update(ID id, Y entity);
    T save(Y entity);
    void delete(ID id);
}
