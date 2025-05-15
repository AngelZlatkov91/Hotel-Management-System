package Hotel.management.hotel.management.Exception;

public class UserIsAlreadyExistExp extends RuntimeException {

    public UserIsAlreadyExistExp(String message) {
        super(message);
    }
    public UserIsAlreadyExistExp(String message, Throwable cause) {
        super(message, cause);
    }
}
