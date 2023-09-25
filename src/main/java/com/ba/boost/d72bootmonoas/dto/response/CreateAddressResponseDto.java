package com.ba.boost.d72bootmonoas.dto.response;

import com.ba.boost.d72bootmonoas.repository.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressResponseDto {

    private String addressName;
    private String content;

}
