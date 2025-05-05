package Gateway.validation.Gateway.validation.Service;

import Gateway.validation.Gateway.validation.DTOS.LoginResponseDTO;
import Gateway.validation.Gateway.validation.DTOS.UserLoginDTO;

public interface AuthService {

    LoginResponseDTO login(UserLoginDTO userLoginDTO);
}
