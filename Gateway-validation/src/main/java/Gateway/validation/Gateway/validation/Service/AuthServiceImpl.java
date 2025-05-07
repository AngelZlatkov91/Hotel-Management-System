package Gateway.validation.Gateway.validation.Service;

import Gateway.validation.Gateway.validation.DTOS.LoginResponseDTO;
import Gateway.validation.Gateway.validation.DTOS.UserLoginDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        RestClient.ResponseSpec retrieve = restClient
                .post()
                .uri("http://localhost:8081/api/user/login")
                .body(userLoginDTO)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();

        ResponseEntity<LoginResponseDTO> body = retrieve.toEntity(LoginResponseDTO.class);
        System.out.println();

        return null;
  }
}
