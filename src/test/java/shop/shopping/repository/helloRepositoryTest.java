package shop.shopping.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.shopping.domain.Hello;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class helloRepositoryTest {
    @Autowired
    helloRepository helloRepository;
    @Test
    void helloTest(){
        Hello hello = new Hello();
        hello.setName("chan");
        helloRepository.save(hello);
        System.out.println(helloRepository.findAll());

        Hello hello1 = new Hello();
        hello1.setName("zz");
        helloRepository.save(hello1);
        org.assertj.core.api.Assertions.assertThat(hello1.getId()).isEqualTo("OW_2");

    }

}