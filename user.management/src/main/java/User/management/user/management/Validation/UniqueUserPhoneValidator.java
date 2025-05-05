package User.management.user.management.Validation;

import User.management.user.management.Repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserPhoneValidator implements ConstraintValidator<UniqueUserPhone, String> {

    private final UserRepository userRepository;

    public UniqueUserPhoneValidator(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return userRepository.findByPhone(value).isEmpty();
    }
}
