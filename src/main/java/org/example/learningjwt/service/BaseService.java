package org.example.learningjwt.service;

import org.example.learningjwt.mapper.BaseMapper;
import org.example.learningjwt.repository.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService <D, E> {
    private final BaseRepository<E> baseRepository;
    private final BaseMapper<D, E> baseMapper;

    protected BaseService(BaseRepository<E> baseRepository, BaseMapper<D, E> baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    public D getById(Long id){
        return baseMapper.toDto(getEntity(id));
    }
    public List<D> getAll(){
        return baseRepository.findAll()
                .stream()
                .map(baseMapper::toDto)
                .collect(Collectors.toList());
    }
    public void update(Long id, D dto){
        E entity = getEntity(id);
        baseMapper.update(entity, dto);
        baseRepository.save(entity);
    }
    public D save(D dto){
        E e = baseRepository.save(baseMapper.toEntity(dto));
        return baseMapper.toDto(e);
    }
    public void delete(Long id){
        baseRepository.deleteById(id);
    }
    protected E getEntity(long id){
        Optional<E> optional = baseRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Entity not found"));
    }

}
