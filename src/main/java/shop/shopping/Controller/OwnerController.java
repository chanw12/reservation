package shop.shopping.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shopping.Service.OwnerService;
import shop.shopping.domain.Dto.OwnerSaveDto;


@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;
    @PostMapping("/register")
    public ResponseEntity<OwnerSaveDto> registerOwner(@RequestBody  OwnerSaveDto dto){
        ownerService.register(dto);

        return ResponseEntity.ok().body(dto);
    }

}
