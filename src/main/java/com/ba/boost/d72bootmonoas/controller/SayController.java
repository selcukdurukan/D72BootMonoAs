package com.ba.boost.d72bootmonoas.controller;

import com.ba.boost.d72bootmonoas.dto.request.AdditionRequestDto;
import com.ba.boost.d72bootmonoas.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ba.boost.d72bootmonoas.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SAY)
public class SayController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, WORLD!!");
    }

    @GetMapping("/addition/{number1}/{number2}")
    public ResponseEntity<String> addition(@PathVariable(name = "number1") Long number1 ,@PathVariable(name = "number2") Long number2) {
        return ResponseEntity.ok("Addition: " + (number1+number2));
    }

    @PostMapping("/addition")
    public ResponseEntity<String> additionPost(@RequestBody AdditionRequestDto dto) {
        return ResponseEntity.ok(memberService.addition(dto));
    }
}
