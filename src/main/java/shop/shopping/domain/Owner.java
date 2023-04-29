package shop.shopping.domain;


import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Owner {

    @Id
    @GeneratedValue(generator = "ow_generator")
    @GenericGenerator(name = "ow_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="OW"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String O_ID;

    @Column
    private String O_PW;

    @Column
    private String O_NAME;

    @Column
    private String O_BIRTH;

    @Column
    private String O_EMAIL;
    @Column
    private String O_PHONE;

    @Column
    private String O_ADDR;

    @Column
    @CreatedDate
    private String O_SD;

    @Column
    private String O_BLCOUNT;

    @Column
    private Boolean O_EAYN;

    @OneToMany(mappedBy = "OWNER")
    private List<Pension> pensions = new ArrayList<Pension>();



}
