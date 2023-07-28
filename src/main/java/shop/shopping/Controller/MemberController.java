package shop.shopping.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.shopping.ErrorResponse;
import shop.shopping.Service.MemberService;
import shop.shopping.domain.Dto.MemberSaveDto;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping ("/register")
    public ResponseEntity<?> registerMember(@RequestBody MemberSaveDto dto){
        memberService.register(dto);
        return ResponseEntity.ok().body(dto);

    }



}
