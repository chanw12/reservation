package shop.shopping.domain;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import shop.shopping.repository.MemberRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MemberTest {
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Rollback(false) // 실제 DB에 저장되도록 설정
    public void testMemberRegistration() {
        // Given
        Member member = new Member("john_doe", "password123", "John Doe", "19900101", "john@example.com", "Male", "010-1234-5678", Member.USERTYPE.USER);

        // When
        Member savedMember = memberRepository.save(member);

        // Then
        assertThat(savedMember.getM_id()).isNotNull();
        assertThat(savedMember.getMuserid()).isEqualTo("john_doe");
        assertThat(savedMember.getM_pwd()).isEqualTo("password123");
        assertThat(savedMember.getM_name()).isEqualTo("John Doe");
        assertThat(savedMember.getM_birth()).isEqualTo("19900101");
        assertThat(savedMember.getM_email()).isEqualTo("john@example.com");
        assertThat(savedMember.getM_gender()).isEqualTo("Male");
        assertThat(savedMember.getM_sd()).isBefore(LocalDateTime.now());
        assertThat(savedMember.getM_phonenumber()).isEqualTo("010-1234-5678");
        assertThat(savedMember.getM_utype()).isEqualTo(Member.USERTYPE.USER);
    }

}