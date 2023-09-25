package com.ba.boost.d72bootmonoas.dto.request;

import com.ba.boost.d72bootmonoas.repository.entity.EGender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMemberRequestDto {

    @NotNull(message = "Member_Id boş geçilemez.")
    private Long id;
    @Size(max = 32, message = "Üye adı maksimum 32 karakter olabilir.")
    private String firstName;
    @Size(max = 32, message = "Üye soyadı maksimum 32 karakter olabilir.")
    private String lastName;
    @Email(message = "Düzgün bir şekilde email adresinizi giriniz.")
    private String email;
    @Size(min = 10, max = 10, message = "10 hane olacak şekilde telefon numaranızı giriniz.")
    private String phone;
    private EGender gender;
    private Boolean isActive;
    private Date birthOfdate;
}
