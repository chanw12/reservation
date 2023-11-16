package shop.shopping.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
public class Owner {

    @Id
    @GeneratedValue(generator = "ow_generator")
    @GenericGenerator(name = "ow_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="OW"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String o_id;

    @Column
    private String o_pw;

    @Column
    private String o_name;

    @Column
    private String o_birth;

    @Column
    private String o_email;
    @Column
    private String o_phone;

    @Column
    private String o_addr;

    @Column
    @CreatedDate
    private String o_sd;

    @Column
    private String o_blcount;

    @Column
    private Boolean o_eayn;

    @OneToMany(mappedBy = "owner")
    private List<Pension> pensions = new ArrayList<Pension>();

    public Owner(String o_pw, String o_name, String o_birth, String o_email, String o_phone, String o_addr, String o_blcount, Boolean o_eayn) {
        this.o_pw = o_pw;
        this.o_name = o_name;
        this.o_birth = o_birth;
        this.o_email = o_email;
        this.o_phone = o_phone;
        this.o_addr = o_addr;
        this.o_blcount = o_blcount;
        this.o_eayn = o_eayn;
    }
}
