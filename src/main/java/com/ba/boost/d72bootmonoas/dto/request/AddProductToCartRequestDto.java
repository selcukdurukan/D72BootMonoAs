package com.ba.boost.d72bootmonoas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductToCartRequestDto {

    private Long member_id;
    private Long product_id;
    private Integer quantity;

}
