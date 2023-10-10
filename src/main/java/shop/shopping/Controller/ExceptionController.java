package shop.shopping.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shop.shopping.ErrorResponse;
import shop.shopping.repository.InvalidFormatException;

@Slf4j
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({
            DataIntegrityViolationException.class

    })
    public ResponseEntity<Object> DataIntegrityVioloationException(final Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage(),HttpStatus.CONFLICT.toString()));
    }
    @ExceptionHandler({
            RuntimeException.class
    })
    public ResponseEntity<Object> RuntimeException(final Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.toString()));
    }
    @ExceptionHandler({
           InvalidFormatException.class
    })
    public ResponseEntity<Object> InvalidPhoneNumberFormatException(final Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.toString()));
    }
}
