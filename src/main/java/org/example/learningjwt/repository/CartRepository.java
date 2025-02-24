package org.example.learningjwt.repository;

import org.example.learningjwt.entity.Cart;
import org.example.learningjwt.entity.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CartRepository extends BaseRepository<Cart> {
    Optional<Cart> findByUserId(Long userId);
}
