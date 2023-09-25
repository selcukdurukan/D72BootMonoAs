package com.ba.boost.d72bootmonoas.repository;


import com.ba.boost.d72bootmonoas.repository.entity.Address;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

    /**
     * HQL
     * @param memberId
     * @return
     */
    @Query(value = "SELECT COUNT(*) FROM Address AS xxx where xxx.member_oid.id=?1", nativeQuery = false)
    Optional<Long> findHowManyAddress(Long memberId);
}
