package Gateway.validation.Gateway.validation.Service;

import Gateway.validation.Gateway.validation.DTOS.LoginResponseDTO;
import Gateway.validation.Gateway.validation.DTOS.UserLoginDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthServiceImpl implements AuthService {

    private final RestClient restClient;

    public AuthServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public LoginResponseDTO login(UserLoginDTO userLoginDTO) {
        return restClient.get().uri("http://localhost:8081/api/user/login")
                .retrieve()
                .body(new ParameterizedTypeReference<LoginResponseDTO>() {});
    }
}
