package shop.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.shopping.domain.Pension;

public interface PensionRepository extends JpaRepository<Pension,String> {
}
