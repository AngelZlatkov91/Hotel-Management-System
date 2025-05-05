package Hotel.management.hotel.management.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueHotelPhoneValidator.class)
public @interface UniqueHotelPhone {
    String message() default "The Hotel phone should be unique";
    Class<?>[] groups()default {};

    Class<? extends Payload>[] payload() default {};

}
