package com.ba.boost.d72bootmonoas.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String addressName;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String neighbourhood;
    @Column(length = 50)
    private String street;
    @Column(length = 5)
    private String postalCode;
    @Column(length = 100)
    private String address;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "member_oid", referencedColumnName = "id" ,nullable = false)
    private Member member_oid;

}
