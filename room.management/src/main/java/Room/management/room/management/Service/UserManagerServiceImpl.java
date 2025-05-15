package Room.management.room.management.Service;

import Room.management.room.management.Models.Entitys.UserManager;
import Room.management.room.management.Repositories.UserManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserManagerServiceImpl implements UserManagerService {


    private final UserManagerRepository userManagerRepository;

    public UserManagerServiceImpl(UserManagerRepository userManagerRepository) {
        this.userManagerRepository = userManagerRepository;
    }

    @Override
    public void addUserManager(String email, String role) {
        Optional<UserManager> byEmail = userManagerRepository.findByEmail(email);
        if (byEmail.isEmpty()) {
            UserManager userManager = new UserManager(email, role);
            userManagerRepository.save(userManager);
        }
    }
}
