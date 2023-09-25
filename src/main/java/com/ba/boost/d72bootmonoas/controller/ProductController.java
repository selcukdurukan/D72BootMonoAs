package com.ba.boost.d72bootmonoas.controller;

import com.ba.boost.d72bootmonoas.dto.request.CreateProductRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateProductRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateProductResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateProductResponseDto;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import com.ba.boost.d72bootmonoas.repository.entity.Product;
import com.ba.boost.d72bootmonoas.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ba.boost.d72bootmonoas.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {

    private final ProductService productService;

    @PostMapping("/createproduct")
    public ResponseEntity<CreateProductResponseDto> createProduct (@RequestBody @Valid CreateProductRequestDto dto) {
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getAllProducts(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/deleteproductbyid")
    public ResponseEntity<String> deleteById(Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<UpdateProductResponseDto> updateProdcut (@RequestBody @Valid UpdateProductRequestDto dto) {
        return ResponseEntity.ok(productService.updateProduct(dto));
    }
}
