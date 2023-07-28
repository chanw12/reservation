package shop.shopping.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shopping.domain.Dto.ReservationSaveDto;
import shop.shopping.domain.Reservation;
import shop.shopping.domain.Room;
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
        reservation.setMEMBER(memberRepository.findById(dto.getMemberId()).get());
        reservation.setRoom(roomRepository.findById(dto.getRoomId()).get());
        Room room = reservation.getRoom();
        if(reservation.getRES_NOP() > room.getR_MAXNOP()) {
            throw new RuntimeException("최대 인원수보다 많은 인원입니다.");
        }

        reservationRepository.save(reservation);

    }

}

//
