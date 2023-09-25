package com.ba.boost.d72bootmonoas.repository;

import com.ba.boost.d72bootmonoas.repository.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByMemberId_Id(Long id);

}
