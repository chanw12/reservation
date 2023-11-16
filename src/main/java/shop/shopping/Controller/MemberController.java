package shop.shopping.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import shop.shopping.Service.MemberService;
import shop.shopping.domain.Dto.MemberSaveDto;
import shop.shopping.repository.InvalidFormatException;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping ("/register")
    public ResponseEntity<?> registerMember(@Valid @RequestBody MemberSaveDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder bd = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                bd.append(message);
            });
            throw new InvalidFormatException(bd.toString());
        }
        memberService.register(dto);
        return ResponseEntity.ok().body(dto);

    }



}
