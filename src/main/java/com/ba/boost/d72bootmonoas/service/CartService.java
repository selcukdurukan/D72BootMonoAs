package com.ba.boost.d72bootmonoas.service;

import com.ba.boost.d72bootmonoas.dto.request.AddProductToCartRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.AddProductToCartResponseDto;
import com.ba.boost.d72bootmonoas.exception.CartServiceException;
import com.ba.boost.d72bootmonoas.exception.ErrorType;
import com.ba.boost.d72bootmonoas.repository.ICartRepository;
import com.ba.boost.d72bootmonoas.repository.entity.Cart;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import com.ba.boost.d72bootmonoas.repository.entity.Product;
import com.ba.boost.d72bootmonoas.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService extends ServiceManager<Cart, Long> {

    private final ICartRepository repository;
    private final MemberService memberService;
    private final ProductService productService;

    public CartService(ICartRepository repository, MemberService memberService, ProductService productService) {
        super(repository);
        this.repository = repository;
        this.memberService = memberService;
        this.productService = productService;
    }


    public AddProductToCartResponseDto addProductToCart(AddProductToCartRequestDto dto) {
        Optional<Member> member = memberService.findAllById(dto.getMember_id());
        if (member.isEmpty())
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        Optional<Product> product = productService.findAllById(dto.getProduct_id());
        if (product.isEmpty())
            throw new CartServiceException(ErrorType.PRODUCT_CANNOT_FOUND);
        if (product.get().getQuantity() < dto.getQuantity())
            throw new CartServiceException(ErrorType.NO_ENOUGH_PRODUCT);

        product.get().setQuantity(product.get().getQuantity() - dto.getQuantity());

        Optional<Cart> cart = repository.findByMemberId_Id(member.get().getId());
        Cart cartResult = new Cart();
        if (cart.isEmpty()) {
            cartResult = Cart.builder()
                    .cartTotalPrice(dto.getQuantity() * product.get().getPrice())
                    .memberId(member.get())
                    .products(product.stream().collect(Collectors.toList()))
                    .build();
            save(cartResult);
        } else {
            cart.get().setCartTotalPrice(cart.get().getCartTotalPrice() + dto.getQuantity() * product.get().getPrice());
            cart.get().getProducts().add(product.get());
            cart.get().setUpdatedDate(System.currentTimeMillis());
            cartResult = cart.get();
            save(cart.get());
        }

        List<String> products = cartResult.getProducts().stream().map(x -> x.getProductName()).collect(Collectors.toList());
        Double cartTotalPrice = cartResult.getCartTotalPrice();
        return AddProductToCartResponseDto.builder()
                .products(products)
                .cartTotalPrice(cartTotalPrice)
                .content("İşlem başarılı. Sırasıyla sepete eklenen ürünler: " + products.toString())
                .build();
    }
}
