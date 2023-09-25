package com.ba.boost.d72bootmonoas.controller;

import com.ba.boost.d72bootmonoas.dto.request.AddProductToCartRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.AddProductToCartResponseDto;
import com.ba.boost.d72bootmonoas.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ba.boost.d72bootmonoas.constants.RestApi.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(CART)
public class CartController {

    private final CartService cartService;

    @PostMapping("/createcart")
    public ResponseEntity<AddProductToCartResponseDto> createCart (AddProductToCartRequestDto dto) {
        return ResponseEntity.ok(cartService.addProductToCart(dto));
    }
}
