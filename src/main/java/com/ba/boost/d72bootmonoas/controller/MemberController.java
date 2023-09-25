package com.ba.boost.d72bootmonoas.controller;

import com.ba.boost.d72bootmonoas.dto.request.CreateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.request.UpdateMemberRequestDto;
import com.ba.boost.d72bootmonoas.dto.response.CreateMemberResponseDto;
import com.ba.boost.d72bootmonoas.dto.response.UpdateMemberResponseDto;
import com.ba.boost.d72bootmonoas.repository.entity.Member;
import com.ba.boost.d72bootmonoas.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ba.boost.d72bootmonoas.constants.RestApi.MEMBER;

@RestController
@RequiredArgsConstructor
@RequestMapping(MEMBER)
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/createmember")
    public ResponseEntity<CreateMemberResponseDto> createMember (@RequestBody @Valid CreateMemberRequestDto dto) {
        return ResponseEntity.ok(memberService.createMember(dto));
    }

    @GetMapping("/getmemberbyid/{id}")
    public ResponseEntity<Member> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @GetMapping("/getallmembers")
    public ResponseEntity<List<Member>> findAllMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @DeleteMapping("/deletememberbyid")
    public ResponseEntity<String> deleteById(Long id) {
        return ResponseEntity.ok(memberService.deleteWithId(id));
    }

    @PutMapping("/updatemember")
    public ResponseEntity<UpdateMemberResponseDto> updateMember(@RequestBody @Valid UpdateMemberRequestDto dto) {
        return ResponseEntity.ok(memberService.updateMember(dto));
    }




}
