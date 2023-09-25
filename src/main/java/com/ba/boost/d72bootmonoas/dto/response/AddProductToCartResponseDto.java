package com.ba.boost.d72bootmonoas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductToCartResponseDto {

    /**
     * Productların adını dönmek için
     */
    private List<String> products;
    private Double cartTotalPrice;
    private String content;
}
