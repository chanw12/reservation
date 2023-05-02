package shop.shopping.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.shopping.domain.Dto.RoomSaveDto;
import shop.shopping.domain.Room;
import shop.shopping.repository.PensionRepository;
import shop.shopping.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final PensionRepository pensionRepository;
    public void register(RoomSaveDto dto){
        Room room = dto.toEntity();
        System.out.println(dto);
        System.out.println(dto.getPensionId());
        room.setPENSION(pensionRepository.findById(dto.getPensionId()).get());
        roomRepository.save(room);

    }

}
