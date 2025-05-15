package Hotel.management.hotel.management.Service;

import Hotel.management.hotel.management.Entitys.Model.User;
import Hotel.management.hotel.management.Repositoriy.UserRepositories;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public void addUserForCreateHotel(String email, String role) {
        if (userRepositories.findByEmail(email).isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setRole(role);
            userRepositories.save(newUser);
        }
    }
}
