package shop.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.shopping.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
