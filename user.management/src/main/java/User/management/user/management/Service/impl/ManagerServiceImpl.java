package User.management.user.management.Service.impl;

import User.management.user.management.Models.DTO.UserChangeRoleDTO;
import User.management.user.management.Models.DTO.UserDetailsDTO;
import User.management.user.management.Models.Entitys.User;
import User.management.user.management.Models.Enum.Role;
import User.management.user.management.Repositories.UserRepository;
import User.management.user.management.Service.Interfaces.ManagerService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private  final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ManagerServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDetailsDTO> getAllUsers(String email) {
        return userRepository.getAllByEmailNotContainingAndRoleIn(email, List.of(Role.RECEPTIONIST,Role.USER)).stream().map(this::mapTo).toList();
    }

    @Override
    @Transactional
    public void changeProfileRole(UserChangeRoleDTO userChangeRoleDTO) {
        Optional<User> byEmail = userRepository.findByEmail(userChangeRoleDTO.getEmail());
        if (byEmail.isPresent()) {
            byEmail.get().setRole(userChangeRoleDTO.getRole());
            userRepository.save(byEmail.get());
        }
    }

    @Override
    @Transactional
    public void deleteProfile(Long id) {
        userRepository.deleteById(id);
    }

    private UserDetailsDTO mapTo(User user) {
        return modelMapper.map(user, UserDetailsDTO.class);
    }
}
