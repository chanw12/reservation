package shop.shopping.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.shopping.domain.Dto.ReservationSaveDto;
import shop.shopping.repository.MemberRepository;
import shop.shopping.repository.ReservationRepository;
import shop.shopping.repository.RoomRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoomRepository roomRepository;
    @Test
    void register() {


    }
}