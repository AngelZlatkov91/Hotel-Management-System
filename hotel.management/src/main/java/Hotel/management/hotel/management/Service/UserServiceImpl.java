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
    public void addUserForCreateHotel(String name, String role) {
        if (userRepositories.findByEmail(name).isEmpty()) {
            User newUser = new User();
            newUser.setEmail(name);
            newUser.setRole(role);
            userRepositories.save(newUser);
        }
    }
}
