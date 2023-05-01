package shop.shopping.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.shopping.Service.PensionService;
import shop.shopping.domain.Dto.PensionSaveDto;

@RestController
@RequestMapping("/pension")
@RequiredArgsConstructor
public class PensionController {
    private final PensionService pensionService;
    @PostMapping("/register")
    public ResponseEntity<PensionSaveDto> pensionRegister(@RequestBody PensionSaveDto dto) {
        pensionService.register(dto);
        return ResponseEntity.ok().body(dto);
    }


}
