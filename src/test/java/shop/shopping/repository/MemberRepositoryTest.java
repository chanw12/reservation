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
        Member member1 = new Member();
        member1.setM_birth("123");
        member1.setM_gender("female");
        member1.setM_pwd("123");
        member1.setM_name("chan");
        member1.setM_phonenumber("01010");
        member1.setM_utype(Member.USERTYPE.MANAGER);
        memberRepository.save(member1);

        Reservation reservation1 = new Reservation();
        reservation1.setMEMBER(member1);
        reservation1.setRES_CHECKIN(new Date(5-15));
        reservation1.setRES_CHECKOUT(new Date(05-16));
        reservation1.setRES_NOP(3L);
        reservation1.setRES_PRICE(100000L);
        reservationRepository.save(reservation1);

        Assertions.assertThat(reservation1.getMEMBER().getM_id()).isEqualTo(member1.getM_id());

    }

}