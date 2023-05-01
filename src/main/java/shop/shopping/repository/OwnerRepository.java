package shop.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.shopping.domain.Owner;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner,String> {
    @Override
    Optional<Owner> findById(String s);
}
