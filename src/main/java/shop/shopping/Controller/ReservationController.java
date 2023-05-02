package shop.shopping.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shopping.Service.ReservationService;
import shop.shopping.domain.Dto.ReservationSaveDto;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/register")
    public ResponseEntity<ReservationSaveDto> registerReserv(@RequestBody ReservationSaveDto dto){
        reservationService.register(dto);
        return ResponseEntity.ok().body(dto);
    }
}
