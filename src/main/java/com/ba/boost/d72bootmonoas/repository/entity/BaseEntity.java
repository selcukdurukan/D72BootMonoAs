package com.ba.boost.d72bootmonoas.repository.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * BaseEntity olması için bu ikisini kullanmak gerekir.
 * @SuperBuilder
 * @MappedSuperClass : Hibernate bunu bu annotation ile superclass olarak alır ve içerdeki field'ları oluşturabilir.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

    @Builder.Default
    private Long createdDate = System.currentTimeMillis();
    @Builder.Default
    private Long updatedDate = System.currentTimeMillis();
}
