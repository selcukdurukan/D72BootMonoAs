package com.ba.boost.d72bootmonoas.service;

import com.ba.boost.d72bootmonoas.dto.request.AdditionRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.CreateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateMemberResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateMemberResponseDto;
import com.ba.boost.d72bootmonoas.exception.ErrorType;
import com.ba.boost.d72bootmonoas.exception.CartServiceException;
import com.ba.boost.d72bootmonoas.mapper.IMemberMapper;
import com.ba.boost.d72bootmonoas.repository.IMemberRepository;
import com.ba.boost.d72bootmonoas.repository.entity.Cart;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import com.ba.boost.d72bootmonoas.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class MemberService extends ServiceManager<Member, Long> {

    private final IMemberRepository repository;
//    private final CartService cartService;

    public MemberService(IMemberRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public String addition(AdditionRequestDto dto) {
        Long totalNumber = dto.getNumber1() + dto.getNumber2();
        return "Addition: " + totalNumber;
    }

    public CreateMemberResponseDto createMember(CreateMemberRequestDto dto) {
        Optional<Member> findMemberByEmail = repository.findOptionalByEmail(dto.getEmail());
        if (findMemberByEmail.isPresent()) {
            throw new CartServiceException(ErrorType.EMAIL_CREATE_ERROR);
        }
        Member member = IMemberMapper.INSTANCE.fromCreateMemberRequestDtoToMember(dto);
        try {

            /**
             * Date'den bugune göre age'i çektik. LocalDate'e parselayarak.
             */
            LocalDate birthDay = LocalDate.from(dto.getBirthOfdate().toInstant().atZone(ZoneId.systemDefault()));
            Period years = Period.between(birthDay, LocalDate.now());
            int age = years.getYears();
            member.setAge(age);
            save(member);
        } catch (Exception e) {
            throw new CartServiceException(ErrorType.MEMBER_CREATE_ERROR);
        }
        CreateMemberResponseDto responseDto = IMemberMapper.INSTANCE.fromMemberToCreateMembersResponseDto(member);
        responseDto.setContent(responseDto.getFirstName() + " " + responseDto.getLastName() + ", " + responseDto.getEmail() + " ile kayıt oldu.");
        return responseDto;
    }

    public Member findById(Long id) {
        Optional<Member> member = findAllById(id);
        if (member.isEmpty()) {
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        }
        return member.get();
    }

    public String deleteWithId(Long id) {
        Optional<Member> member = findAllById(id);
        if (member.isEmpty()) {
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        }
        if (member.isPresent()) {
            Member deleteMember = member.get();
            deleteMember.setIsActive(false);
            deleteMember.setUpdatedDate(System.currentTimeMillis());
            save(deleteMember);
        }
        return   "Deleting process of " + member.get().getEmail() + " is successful.";
    }

    public UpdateMemberResponseDto updateMember(UpdateMemberRequestDto dto) {
        Optional<Member> findMemberById = findAllById(dto.getId());
        if (findMemberById.isEmpty()) {
            throw new CartServiceException(ErrorType.MEMBER_CANNOT_FOUND);
        }
        checkMemberFields(dto, findMemberById);
        save(findMemberById.get());
        return UpdateMemberResponseDto.builder()
                .email(findMemberById.get().getEmail())
                .content(findMemberById.get().getEmail() + " ile güncelleme işlemi başarılı bir şekilde gerçekleşti.")
                .build();
    }

    private void checkMemberFields(UpdateMemberRequestDto dto, Optional<Member> findMemberById) {
        if (dto.getFirstName() != null) findMemberById.get().setFirstName(dto.getFirstName());
        if (dto.getLastName() != null ) findMemberById.get().setLastName(dto.getLastName());
        if (dto.getLastName() != null ) findMemberById.get().setEmail(dto.getEmail());
        if (dto.getPhone() != null ) findMemberById.get().setPhone(dto.getPhone());
        if (dto.getGender() != null ) findMemberById.get().setGender(dto.getGender());
        if (dto.getIsActive() != null ) findMemberById.get().setIsActive(dto.getIsActive());
        if (dto.getBirthOfdate() != null) {
            findMemberById.get().setBirthOfdate(dto.getBirthOfdate());
            LocalDate birthDay = LocalDate.from(dto.getBirthOfdate().toInstant().atZone(ZoneId.systemDefault()));
            Period years = Period.between(birthDay, LocalDate.now());
            int age = years.getYears();
            findMemberById.get().setAge(age);
        }
        findMemberById.get().setUpdatedDate(System.currentTimeMillis());
    }
}
