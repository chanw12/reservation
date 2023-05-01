package shop.shopping.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shopping.domain.Dto.MemberSaveDto;
import shop.shopping.domain.Member;
import shop.shopping.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void register(MemberSaveDto dto){
        Member member = dto.toEntity();
        memberRepository.save(member);

    }

}
