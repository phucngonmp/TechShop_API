package org.example.learningjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface  BaseRepository<E> extends JpaRepository<E, Long> {
}
