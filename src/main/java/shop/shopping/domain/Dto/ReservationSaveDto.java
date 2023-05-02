package shop.shopping.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.shopping.domain.Reservation;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationSaveDto {

    private Date res_checkin;
    private Date res_checkout;
    private Reservation.RES_STA res_state;
    private Long res_nop;
    private Long res_price;
    private String memberId;

    public Reservation toEntity(){
        Reservation reservation = new Reservation(res_checkin, res_checkout, res_state, res_nop, res_price);
        return reservation;
    }
}

