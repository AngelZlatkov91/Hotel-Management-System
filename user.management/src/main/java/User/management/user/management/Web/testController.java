package User.management.user.management.Web;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/home")
public class testController {

    @GetMapping
    public ResponseEntity<Boolean> home(Authentication authentication) {

        String string = authentication.getPrincipal().toString();
        System.out.println();

        return ResponseEntity.ok(true);
    }
}
