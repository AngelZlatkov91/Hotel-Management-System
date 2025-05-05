package Hotel.management.hotel.management.Validation;

import Hotel.management.hotel.management.Repositoriy.HotelRepositories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueHotelNameValidator implements ConstraintValidator<UniqueHotelName, String> {

    private final HotelRepositories  hotelRepositories;

    public UniqueHotelNameValidator(HotelRepositories hotelRepositories) {
        this.hotelRepositories = hotelRepositories;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return hotelRepositories.findByName(value).isEmpty();
    }
}
