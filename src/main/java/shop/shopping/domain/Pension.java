package shop.shopping.domain;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @EntityListeners(AuditingEntityListener.class)
public class Pension {

    @Id
    @GeneratedValue(generator = "pension_generator")
    @GenericGenerator(name = "pension_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="PS"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String P_ID;

    @Column(nullable = false)
    private String P_NAME;

    @Column(nullable = false)
    private String P_ADDR;

    @Column(nullable = false)
    private String P_TEL;

    @Column(nullable = false)
    private Long P_BLCOUNT;

    @Column(nullable = false)
    private LocalDateTime P_ENROLLDATE;

    @ManyToOne
    @JoinColumn
    private Owner OWNER;

    @OneToMany(mappedBy = "PENSION")
    private List<Room> rooms = new ArrayList<Room>();


}
