package com.ba.boost.d72bootmonoas.dto.response;

import com.ba.boost.d72bootmonoas.repository.entity.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMemberResponseDto {

    private String firstName;
    private String lastName;
    private String email;
    private String content;
}
