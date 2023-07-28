package shop.shopping.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.shopping.domain.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member,String> {


    boolean existsBymuserid(String muserid);
}
