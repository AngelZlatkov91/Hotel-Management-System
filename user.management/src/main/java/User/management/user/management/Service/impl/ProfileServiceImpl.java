package User.management.user.management.Service.impl;
import User.management.user.management.Models.DTO.UserDetailsDTO;
import User.management.user.management.Models.Entitys.User;
import User.management.user.management.Repositories.UserRepository;
import User.management.user.management.Service.Interfaces.ProfileService;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public  class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    public ProfileServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsDTO getUserDetails(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        return byEmail.map(this::mapTo).orElse(null);
    }


    private UserDetailsDTO mapTo(User user) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setEmail(user.getEmail());
        userDetailsDTO.setUsername(user.getUsername());
        userDetailsDTO.setPhone(user.getPhone());
        userDetailsDTO.setAge(user.getAge());
        userDetailsDTO.setRole(user.getRole().toString());
        userDetailsDTO.setId(user.getId());
        return userDetailsDTO;
    }
}
