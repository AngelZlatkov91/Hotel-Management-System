package User.management.user.management.Web;

import User.management.user.management.Models.DTO.UserRegisterDTO;
import User.management.user.management.Service.Interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping( "/api/user")
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("userRegistrationDTO")
    public UserRegisterDTO initForm(){
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView ("register");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterDTO userRegistrationDTO ,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String defaultMessage = allErrors.get(0).getDefaultMessage();

            return ResponseEntity.badRequest().body(defaultMessage);
        }
        try {
            userService.registerUser(userRegistrationDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }

    }
}
