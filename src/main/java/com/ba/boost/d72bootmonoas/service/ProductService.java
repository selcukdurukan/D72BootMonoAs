package com.ba.boost.d72bootmonoas.service;

import com.ba.boost.d72bootmonoas.dto.request.CreateProductRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateProductRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateProductResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateProductResponseDto;
import com.ba.boost.d72bootmonoas.exception.CartServiceException;
import com.ba.boost.d72bootmonoas.exception.ErrorType;
import com.ba.boost.d72bootmonoas.mapper.IProductMapper;
import com.ba.boost.d72bootmonoas.repository.IProductRepository;
import com.ba.boost.d72bootmonoas.repository.entity.Product;
import com.ba.boost.d72bootmonoas.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public CreateProductResponseDto createProduct(CreateProductRequestDto dto) {
        return IProductMapper.INSTANCE.toProductResponseDto(save(IProductMapper.INSTANCE.toProduct(dto)));
    }

    public List<Product> getAllProducts() {
        return findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = findAllById(id);
        if (product.isEmpty())
            throw new CartServiceException(ErrorType.PRODUCT_CANNOT_FOUND);
        return product.get();
    }

    public String deleteProduct(Long id) {
        Optional<Product> product = findAllById(id);
        if (product.isEmpty())
            throw new CartServiceException(ErrorType.PRODUCT_CANNOT_FOUND);
        delete(product.get());
        return "Ürün başarıyla silindi.";
    }

    public UpdateProductResponseDto updateProduct (UpdateProductRequestDto dto) {
        Optional<Product> product = findAllById(dto.getId());
        if (product.isEmpty())
            throw new CartServiceException(ErrorType.PRODUCT_CANNOT_FOUND);
        if (dto.getProductName() != null) product.get().setProductName(dto.getProductName());
        if (dto.getPrice() != null) product.get().setPrice(dto.getPrice());
        if (dto.getQuantity() != null) product.get().setQuantity(dto.getQuantity());
        if (dto.getQuantityType() != null) product.get().setQuantityType(dto.getQuantityType());
        product.get().setUpdatedDate(System.currentTimeMillis());
        save(product.get());
        return IProductMapper.INSTANCE.fromProduct(product.get());
    }

}
