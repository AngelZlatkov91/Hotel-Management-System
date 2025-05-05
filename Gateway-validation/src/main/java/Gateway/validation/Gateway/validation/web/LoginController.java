package Gateway.validation.Gateway.validation.web;

import Gateway.validation.Gateway.validation.DTOS.LoginResponseDTO;
import Gateway.validation.Gateway.validation.DTOS.UserLoginDTO;
import Gateway.validation.Gateway.validation.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
  private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody UserLoginDTO userLoginDTO) {

          return ResponseEntity.ok(authService.login(userLoginDTO));
    }

}
