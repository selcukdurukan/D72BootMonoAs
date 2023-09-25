package com.ba.boost.d72bootmonoas.dto.request;

import com.ba.boost.d72bootmonoas.repository.entity.EGender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMemberRequestDto {

    @NotBlank(message = "Üye adı boş geçilemez")
    @Size(max = 32, message = "Üye adı maksimum 32 karakter olabilir.")
    private String firstName;
    @NotBlank(message = "Üye soyadı boş geçilemez")
    @Size(max = 32, message = "Üye soyadı maksimum 32 karakter olabilir.")
    private String lastName;
    @Email(message = "Düzgün bir şekilde email adresinizi giriniz.")
    private String email;
    @Size(min = 10, max = 10, message = "10 hane olacak şekilde telefon numaranızı giriniz.")
    private String phone;
    /**
     * Oto convert işlemi, doğum tarihini yaşa dönüştürüyor. util.Date (before java 8) to LocalDate(Java 8 Date-time)
     */
//    @Positive(message = "Yaşınız 0'dan büyük olmalı.")
//    @Max(value = 1000, message = "Yaşınız maximum 3 haneli bir sayı olabilir.")
//    private Integer age;
    private Date birthOfdate;
    private EGender gender;

}
