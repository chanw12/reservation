package shop.shopping.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shopping.domain.Dto.MemberSaveDto;
import shop.shopping.domain.Member;
import shop.shopping.repository.MemberRepository;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void register(MemberSaveDto dto){
        Member member = dto.toEntity();
        if(memberRepository.existsBymuserid(member.getMuserid())){
            throw new DataIntegrityViolationException("이미 존재하는 아이디 입니다");
        }else{
            memberRepository.save(member);
        }



    }

}
