package shop.shopping.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shopping.Service.RoomService;
import shop.shopping.domain.Dto.RoomSaveDto;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    @PostMapping("/register")
    public ResponseEntity<RoomSaveDto> register(@RequestBody RoomSaveDto dto){
        roomService.register(dto);
        return ResponseEntity.ok().body(dto);
    }


}
