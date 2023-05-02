package shop.shopping.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.shopping.domain.Dto.ReservationSaveDto;
import shop.shopping.domain.Reservation;
import shop.shopping.repository.MemberRepository;
import shop.shopping.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    public void register(ReservationSaveDto dto){
        Reservation reservation = dto.toEntity();
        reservation.setMEMBER(memberRepository.findById(dto.getMemberId()).get());
        reservationRepository.save(reservation);

    }

}
