package org.example.learningjwt.repository;

import org.example.learningjwt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product> {
}
