package shop.shopping.domain.Dto;

import lombok.Data;
import shop.shopping.domain.Room;

@Data
public class RoomSaveDto {
    private String r_name;
    private Long r_price;
    private Long r_maxnop;
    private Long r_size;
    private String pensionId;
    public Room toEntity(){
        Room room = new Room(r_name,r_price,r_maxnop,r_size);
        return room;
    }

}
