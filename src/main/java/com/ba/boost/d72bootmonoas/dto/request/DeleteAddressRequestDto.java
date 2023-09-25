package com.ba.boost.d72bootmonoas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteAddressRequestDto {

    @NotNull(message = "member_id boş geçilemez.")
    private Long member_Id;
    @NotNull(message = "address_id boş geçilemez.")
    private Long address_Id;

}
