package com.ba.boost.d72bootmonoas.dto.response;

import com.ba.boost.d72bootmonoas.repository.entity.EQuantityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductResponseDto {

    private Long id;
    private String productName;
    private Double price;
    private Integer quantity;
    private EQuantityType quantityType;
}
