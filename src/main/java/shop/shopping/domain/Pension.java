package shop.shopping.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Setter
@Getter
public class Pension {

    @Id
    @GeneratedValue(generator = "pension_generator")
    @GenericGenerator(name = "pension_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="PS"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String P_ID;

    @Column(nullable = false)
    private String p_name;

    @Column(nullable = false)
    private String p_addr;

    @Column(nullable = false)
    private String p_tel;

    @Column(nullable = false)
    private Long p_blcount;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime p_enrolldate;

    @ManyToOne
    @JoinColumn
    private Owner owner;

    @OneToMany(mappedBy = "PENSION")
    private List<Room> rooms = new ArrayList<Room>();

    public Pension(String p_name, String p_addr, String p_tel, Long p_blcount) {
        this.p_name = p_name;
        this.p_addr = p_addr;
        this.p_tel = p_tel;
        this.p_blcount = p_blcount;
    }
}
