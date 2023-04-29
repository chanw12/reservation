package shop.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.shopping.domain.Hello;

import java.util.Optional;

@Repository
public interface helloRepository extends JpaRepository<Hello,String> {
    Hello save(Hello hello);
}

