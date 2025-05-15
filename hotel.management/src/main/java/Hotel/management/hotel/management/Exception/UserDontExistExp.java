package Hotel.management.hotel.management.Exception;

public class UserDontExistExp extends RuntimeException {

    public UserDontExistExp(String message) {
        super(message);
    }
    public UserDontExistExp(String message, Throwable cause) {
        super(message, cause);
    }
}
