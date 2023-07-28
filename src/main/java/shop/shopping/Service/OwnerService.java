package shop.shopping.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shopping.domain.Dto.OwnerSaveDto;
import shop.shopping.domain.Owner;
import shop.shopping.repository.OwnerRepository;

@RequiredArgsConstructor
@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    @Transactional
    public void register(OwnerSaveDto dto){
        Owner owner = dto.toEntity();
        ownerRepository.save(owner);

    }
}
