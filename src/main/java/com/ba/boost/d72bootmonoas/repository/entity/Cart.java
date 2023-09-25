package com.ba.boost.d72bootmonoas.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DialectOverride;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cartTotalPrice;

    @OneToOne
    @JoinColumn(name = "member_oid", referencedColumnName = "id", nullable = false)
    private Member memberId;

    /**
     * Bir cartta bir userin bir userın birden fazla product'ı olacağı,
     * product'ınde birden fazla user'ın cart'ında olacagı için many-to-many
     * ilişki kullandık.
     *
     * Diğer tarafta many-to-many'yi kapattık çünkü biz istiyoruz ki apiden request
     * yolladığımızda product kısmında carts listesi gelmesin.
     */
    @ManyToMany
    @JoinTable(name = "carts_products", joinColumns = {@JoinColumn(name= "carts_id")}, inverseJoinColumns = {@JoinColumn(name="products_id")})
    private List<Product> products;
}
