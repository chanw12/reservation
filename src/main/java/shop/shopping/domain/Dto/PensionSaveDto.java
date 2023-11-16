package shop.shopping.domain.Dto;

import lombok.Data;
import shop.shopping.domain.Pension;

@Data
public class PensionSaveDto {

    private String p_name;

    private String p_addr;

    private String p_tel;

    private Long p_blcount;


    private String owner_id;

    public Pension toEntity(){
        Pension pension = new Pension(p_name,p_addr,p_tel,p_blcount);
        return pension;
    }
}
