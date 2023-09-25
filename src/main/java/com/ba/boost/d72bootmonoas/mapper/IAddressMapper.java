package com.ba.boost.d72bootmonoas.mapper;

import com.ba.boost.d72bootmonoas.dto.request.CreateAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateAddressResponseDto;
import com.ba.boost.d72bootmonoas.repository.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAddressMapper {

    IAddressMapper INSTANCE = Mappers.getMapper(IAddressMapper.class);


    Address fromCreateAddressRequestDtoToAddress(final CreateAddressRequestDto dto);

    CreateAddressResponseDto fromAddressToCreateAddressResponseDto(final Address address);
}
