package shop.shopping.domain;


import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(generator = "room_generator")
    @GenericGenerator(name = "room_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="RM"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String R_NO;

    @Column
    private String R_NAME;

    @Column
    private Long R_PRICE;

    @Column
    private Long R_MAXNOP;

    @Column
    private Long R_SIZE;


    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<Reservation>();


    @ManyToOne
    @JoinColumn
    private Pension PENSION;

    public Room(String r_NAME, Long r_PRICE, Long r_MAXNOP, Long r_SIZE) {
        this.R_NAME = r_NAME;
        this.R_PRICE = r_PRICE;
        this.R_MAXNOP = r_MAXNOP;
        this.R_SIZE = r_SIZE;
    }
}
