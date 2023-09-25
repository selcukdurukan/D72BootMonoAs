package com.ba.boost.d72bootmonoas.dto.request;

import com.ba.boost.d72bootmonoas.repository.entity.EQuantityType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequestDto {

    @NotBlank(message = "Ürün adı boş bırakılamaz.")
    @Size(max = 50, message = "Maksimum 50 karakter girebilirsiniz.")
    private String productName;
    @Positive(message = "Girdiginiz değer pozitif olmalı.")
    private Double price;
    @Positive(message = "Girdiginiz değer pozitif olmalı.")
    private Integer quantity;
    @NotNull(message = "Ölçü birimi boş bırakılamaz.")
    private EQuantityType quantityType;
}
