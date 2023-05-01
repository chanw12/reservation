package shop.shopping.domain.Dto;

import lombok.Data;
import shop.shopping.domain.Owner;


@Data
public class OwnerSaveDto {
    private String o_pw;

    private String o_name;

    private String o_birth;

    private String o_email;
    private String o_phone;

    private String o_addr;


    private String o_blcount;

    private Boolean o_eayn;

    public Owner toEntity(){
        Owner owner = new Owner(o_pw,o_name,o_birth,o_email,o_phone,o_addr,o_blcount,o_eayn);
        return owner;
    }
}
