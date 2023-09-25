package com.ba.boost.d72bootmonoas.controller;

import com.ba.boost.d72bootmonoas.dto.request.CreateAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.DeleteAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateAddressResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateAddressResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateMemberResponseDto;
import com.ba.boost.d72bootmonoas.repository.entity.Address;
import com.ba.boost.d72bootmonoas.service.AddressService;
import com.ba.boost.d72bootmonoas.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ba.boost.d72bootmonoas.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADDRESS)
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/createaddress")
    public ResponseEntity<CreateAddressResponseDto> createAddress(@RequestBody @Valid CreateAddressRequestDto dto) {
        return ResponseEntity.ok(addressService.createAddress(dto));
    }

    @GetMapping("/getall/{memberId}")
    public ResponseEntity<List<Address>> gettAllByMemberId(@PathVariable(name = "memberId") Long memberId) {
        return ResponseEntity.ok(addressService.gettAllByMemberId(memberId));
    }

    @GetMapping("/getalladdresses")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @PutMapping("/updateaddress")
    public ResponseEntity<UpdateAddressResponseDto> updateAddress(@RequestBody @Valid UpdateAddressRequestDto dto) {
        return ResponseEntity.ok(addressService.updateAddress(dto));
    }

    @DeleteMapping("/deleteaddress")
    public ResponseEntity<String> deleteAddress(@RequestBody @Valid DeleteAddressRequestDto dto) {
        return ResponseEntity.ok(addressService.deleteAddress(dto));
    }




}
