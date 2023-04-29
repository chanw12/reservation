package shop.shopping.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
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


    @ManyToOne
    @JoinColumn
    private Reservation RESERVATION;

    @ManyToOne
    @JoinColumn
    private Pension PENSION;






}
