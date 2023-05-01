package shop.shopping.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shopping.domain.Dto.PensionSaveDto;
import shop.shopping.domain.Pension;
import shop.shopping.repository.OwnerRepository;
import shop.shopping.repository.PensionRepository;

@Service
@RequiredArgsConstructor
public class PensionService {
    private final PensionRepository pensionRepository;
    private final OwnerRepository ownerRepository;
    @Transactional
    public void register(PensionSaveDto dto){
        Pension pension = dto.toEntity();

        System.out.println("---------------");
        System.out.println(dto);
        pension.setOwner(ownerRepository.findById(dto.getOwner_id()).get());
        pensionRepository.save(pension);
        System.out.println(pension.getOwner().getO_name());

    }
}
