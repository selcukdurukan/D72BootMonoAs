package com.ba.boost.d72bootmonoas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAddressRequestDto {

    @NotNull(message = "member_id boş geçilemez.")
    private Long member_id;
    @NotNull(message = "address_id boş geçilemez.")
    private Long id;
    @NotBlank(message = "Adres adı boş geçilemez.")
    @Size(max = 50, message = "Maksimum karakter 50.")
    private String addressName;
    @NotBlank(message = "Şehir adı boş geçilemez.")
    @Size(max = 50, message = "Maksimum karakter 50.")
    private String city;
    @NotBlank(message = "Mahalle adı boş geçilemez.")
    @Size(max = 50, message = "Maksimum karakter 50.")
    private String neighbourhood;
    @NotBlank(message = "Sokak/cadde/bulvar adı boş geçilemez.")
    @Size(max = 50, message = "Maksimum karakter 50.")
    private String street;
    @NotBlank(message = "Sokak/cadde/bulvar adı boş geçilemez.")
    @Size(min = 5 , max = 5, message = "Posta kodunuz 5 haneli olmalı.")
    private String postalCode;
    @NotBlank(message = "Adress özeti boş geçilemez.")
    @Size(max = 100, message = "Maksimum karakter 100.")
    private String address;

}
