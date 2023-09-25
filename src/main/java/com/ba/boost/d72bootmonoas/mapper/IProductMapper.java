package com.ba.boost.d72bootmonoas.mapper;

import com.ba.boost.d72bootmonoas.dto.request.CreateProductRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateProductRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateProductResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateProductResponseDto;
import com.ba.boost.d72bootmonoas.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product toProduct(final CreateProductRequestDto dto);

    CreateProductResponseDto toProductResponseDto(final Product product);

    UpdateProductResponseDto fromProduct(final Product product);
}
