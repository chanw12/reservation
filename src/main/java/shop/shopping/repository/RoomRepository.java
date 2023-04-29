package shop.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.shopping.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,String> {

}
