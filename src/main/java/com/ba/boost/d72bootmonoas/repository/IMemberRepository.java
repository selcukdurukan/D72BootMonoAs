package com.ba.boost.d72bootmonoas.repository;

import com.ba.boost.d72bootmonoas.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findOptionalByEmail(String email);

}
