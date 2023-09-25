package com.ba.boost.d72bootmonoas.mapper;

import com.ba.boost.d72bootmonoas.dto.request.CreateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateMemberResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateMemberResponseDto;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMemberMapper {

    IMemberMapper INSTANCE = Mappers.getMapper(IMemberMapper.class);

    Member fromCreateMemberRequestDtoToMember (final CreateMemberRequestDto dto);

    CreateMemberResponseDto fromMemberToCreateMembersResponseDto(final Member member);


}
