package shop.shopping.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
    public enum RES_STA{
        COMPLETE,NOTCOMPLETE
    }

    @Id
    @GeneratedValue(generator = "reservation_generator")
    @GenericGenerator(name = "reservation_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="RE"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String RES_CODE;

    @Column //예약 생성 날짜
    @CreatedDate
    private LocalDateTime RES_CREDATE;

    @Column
    private Date RES_CHECKIN;

    @Column
    private Date RES_CHECKOUT;

    @Column
    private RES_STA RES_STATE;

    @Column
    private Long RES_NOP;

    @Column
    private Long RES_PRICE;

    @ManyToOne
    @JoinColumn
    private Member MEMBER;


    @OneToMany(mappedBy = "RESERVATION")
    private List<Room> rooms = new ArrayList<Room>();

    public Reservation(Date RES_CHECKIN, Date RES_CHECKOUT, RES_STA RES_STATE, Long RES_NOP, Long RES_PRICE) {
        this.RES_CHECKIN = RES_CHECKIN;
        this.RES_CHECKOUT = RES_CHECKOUT;
        this.RES_STATE = RES_STATE;
        this.RES_NOP = RES_NOP;
        this.RES_PRICE = RES_PRICE;
    }
}
