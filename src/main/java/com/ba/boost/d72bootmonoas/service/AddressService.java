package com.ba.boost.d72bootmonoas.service;

import com.ba.boost.d72bootmonoas.dto.request.CreateAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.DeleteAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateAddressRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateAddressResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateAddressResponseDto;
import com.ba.boost.d72bootmonoas.exception.CartServiceException;
import com.ba.boost.d72bootmonoas.exception.ErrorType;
import com.ba.boost.d72bootmonoas.mapper.IAddressMapper;
import com.ba.boost.d72bootmonoas.repository.IAddressRepository;
import com.ba.boost.d72bootmonoas.repository.entity.Address;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import com.ba.boost.d72bootmonoas.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService extends ServiceManager<Address, Long> {

    private final IAddressRepository repository;
    private final MemberService memberService;


    public AddressService(IAddressRepository repository, MemberService memberService) {
        super(repository);
        this.repository = repository;
        this.memberService = memberService;
    }

    public CreateAddressResponseDto createAddress(CreateAddressRequestDto dto) {
        Optional<Member> member = memberService.findAllById(dto.getMember_id());
        if (member.isEmpty())
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        Optional<Long> totalMemberAdresses = repository.findHowManyAddress(member.get().getId());
        if (totalMemberAdresses.isPresent()) {
            if (totalMemberAdresses.get() > 2)
                throw new CartServiceException(ErrorType.ADDRESS_CREATE_ERROR);
        }
        Address address = IAddressMapper.INSTANCE.fromCreateAddressRequestDtoToAddress(dto);
        address.setMember_oid(member.get());
        save(address);
        CreateAddressResponseDto responseDto = IAddressMapper.INSTANCE.fromAddressToCreateAddressResponseDto(address);
        responseDto.setContent(member.get().getEmail() + ", hesabınıza " + responseDto.getAddressName() + " isimli adresiniz kaydedildi.");
        return responseDto;
    }


    public List<Address> gettAllByMemberId(Long memberId) {
        Optional<Member> member = memberService.findAllById(memberId);
        if (member.isEmpty())
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        return member.get().getAddresses();
    }

    public List<Address> getAllAddress() {
        return findAll();
    }

    public UpdateAddressResponseDto updateAddress(UpdateAddressRequestDto dto) {
        Optional<Member> member = memberService.findAllById(dto.getMember_id());
        if (member.isEmpty())
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        Optional<Address> address = findAllById(dto.getId());
        if (address.isEmpty())
            throw new CartServiceException(ErrorType.ADDRESS_CANNOT_FOUND);
        if (dto.getAddressName() != null) address.get().setAddressName(dto.getAddressName());
        if (dto.getCity() != null) address.get().setCity(dto.getCity());
        if (dto.getNeighbourhood() != null) address.get().setNeighbourhood(dto.getNeighbourhood());
        if (dto.getStreet() != null) address.get().setStreet(dto.getStreet());
        if (dto.getPostalCode() != null) address.get().setPostalCode(dto.getPostalCode());
        if (dto.getAddress() != null) address.get().setAddress(dto.getAddress());
        address.get().setUpdatedDate(System.currentTimeMillis());
        save(address.get());
        return UpdateAddressResponseDto.builder()
                .addressName(dto.getAddress())
                .content(member.get().getEmail() + ", hesabınızda bulunan " + address.get().getAddressName()+ " isimli adresiniz güncellendi.")
                .build();
    }

    public String deleteAddress(DeleteAddressRequestDto dto) {
        Optional<Member> member = memberService.findAllById(dto.getMember_Id());
        if (member.isEmpty())
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        Optional<Address> address = findAllById(dto.getAddress_Id());
        if (address.isEmpty())
            throw new CartServiceException(ErrorType.ADDRESS_CANNOT_FOUND);
        delete(address.get());
        return "Addresiniz başarıyla silindi.";
    }
}
