package Hotel.management.hotel.management.Validation;
import Hotel.management.hotel.management.Repositoriy.HotelRepositories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueHotelEmailValidator implements ConstraintValidator<UniqueHotelEmail, String> {

    private final HotelRepositories hotelRepositories;

    public UniqueHotelEmailValidator(HotelRepositories hotelRepositories) {

        this.hotelRepositories = hotelRepositories;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return hotelRepositories.findByEmail(value).isEmpty();
    }
}
