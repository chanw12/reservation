package shop.shopping.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shopping.domain.Dto.ReservationSaveDto;
import shop.shopping.domain.Reservation;
import shop.shopping.repository.MemberRepository;
import shop.shopping.repository.ReservationRepository;
import shop.shopping.repository.RoomRepository;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;
    @Transactional
    public void register(ReservationSaveDto dto){
        Reservation reservation = dto.toEntity();
        System.out.println(dto);
        reservation.setMEMBER(memberRepository.findById(dto.getMemberId()).get());
        reservation.setRoom(roomRepository.findById(dto.getRoomId()).get());
        reservationRepository.save(reservation);

    }

}

//
