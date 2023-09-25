package com.ba.boost.d72bootmonoas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdditionRequestDto {

    private Long number1;
    private Long number2;
}
