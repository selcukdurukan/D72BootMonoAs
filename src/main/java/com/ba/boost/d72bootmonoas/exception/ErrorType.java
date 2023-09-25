package com.ba.boost.d72bootmonoas.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(1000, "Parametre Hatası, girdiğiniz parametreleri kontrol ediniz.", HttpStatus.BAD_REQUEST),
    ADDITION_ERROR(1001, "Lütfen sayıları doğru şekilde giriniz.", HttpStatus.BAD_REQUEST),
    EMAIL_CREATE_ERROR(1002, "Bu email ile daha önce kayıt olundu.", HttpStatus.BAD_REQUEST),
    MEMBER_CREATE_ERROR(1003, "Üye oluşturulamadı.", HttpStatus.BAD_REQUEST),
    MEMBER_CANNOT_FOUND(1004, "Üye bulunamadı.", HttpStatus.NOT_FOUND),
    ADDRESS_CREATE_ERROR(1005, "Kayıtlı adres sayınız en fazla 3 olabilir.", HttpStatus.BAD_REQUEST),
    ADDRESS_CANNOT_FOUND(1006, "Adres bulunamadı", HttpStatus.NOT_FOUND),
    PRODUCT_CANNOT_FOUND(1007, "Ürün bulunamadı", HttpStatus.NOT_FOUND),
    NO_ENOUGH_PRODUCT(1008, "İstediginiz miktarda ürün yok", HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
