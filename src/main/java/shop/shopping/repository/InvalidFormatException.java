package shop.shopping.repository;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException(String message) {
        super(message);
    }
}
