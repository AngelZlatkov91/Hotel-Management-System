package User.management.user.management.Service.impl;
import User.management.user.management.Exception.UserDontExistExp;
import User.management.user.management.Models.DTO.UserDetailsDTO;
import User.management.user.management.Models.Entitys.User;
import User.management.user.management.Repositories.UserRepository;
import User.management.user.management.Service.Interfaces.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public  class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ProfileServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetailsDTO getUserDetails(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new UserDontExistExp("User with email " + email + " does not exist");
        }
        return byEmail.map(this::mapTo).orElse(null);
    }


    private UserDetailsDTO mapTo(User user) {
        return modelMapper.map(user, UserDetailsDTO.class);
    }
}
