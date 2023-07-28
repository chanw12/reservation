package shop.shopping;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String code;


}
