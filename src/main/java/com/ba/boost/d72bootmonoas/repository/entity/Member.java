package com.ba.boost.d72bootmonoas.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "members")
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Builder.Default
    private String phoneCode = "90";
    @Column(name = "phone", length = 10)
    private String phone;
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date birthOfdate;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Builder.Default
    private Boolean isActive = true;

    /**
     * Bir kişinin birden fazla address'i olabilecegi için one-to-many.
     * JsonManagedReference ve JsonBackReference infinitive loop için kullanılıyor.
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "member_oid")
    private List<Address> addresses;

    /**
     * Her member'in bir tane sepeti olması gerektiği için one-to-one ilişki kuruyoruz.
     */
    @OneToOne(mappedBy = "memberId")
    private Cart cart;

}
