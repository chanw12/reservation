package shop.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.shopping.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner,String> {
}
