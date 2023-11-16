package shop.shopping.domain;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import shop.shopping.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 아이디가_같은_멤버_가입() throws Exception {
        //given
        Member member1 = new Member("chanwoo","123", "kang", "1998-12-12", "wooju343@naver.com", "MALE", "010-6009835", Member.USERTYPE.USER);
        Member member2 = new Member("chanwoo","123", "kang", "1998-12-12", "wooju343@naver.com", "MALE", "010-6009835", Member.USERTYPE.USER);

        memberRepository.save(member1);


        Assertions.assertThrows(DataIntegrityViolationException.class, ()->memberRepository.save(member2));

    }

}