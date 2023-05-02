package shop.shopping.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.shopping.domain.Member;
import shop.shopping.domain.Reservation;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void saveTest(){

    }

}