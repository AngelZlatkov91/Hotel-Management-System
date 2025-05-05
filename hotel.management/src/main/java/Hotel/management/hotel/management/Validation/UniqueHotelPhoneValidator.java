package Hotel.management.hotel.management.Validation;

import Hotel.management.hotel.management.Repositoriy.HotelRepositories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueHotelPhoneValidator implements ConstraintValidator<UniqueHotelPhone, String> {

    private final HotelRepositories hotelRepositories;

    public UniqueHotelPhoneValidator(HotelRepositories hotelRepositories) {

        this.hotelRepositories = hotelRepositories;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return hotelRepositories.findByPhone(value).isEmpty();
    }
}
