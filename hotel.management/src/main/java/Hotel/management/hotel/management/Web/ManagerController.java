package Hotel.management.hotel.management.Web;

import Hotel.management.hotel.management.Entitys.DTO.CreateHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.UpdateHotelDTO;
import Hotel.management.hotel.management.Service.HotelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hotel/manager")
public class ManagerController {


    private final HotelService hotelService;

    public ManagerController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/me")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_MANAGER')")
    public ResponseEntity<String> currentUser(@AuthenticationPrincipal Jwt jwt) {
        String username = jwt.getSubject();
        Map<String, Object> claims =
                jwt.getClaims();
        String scope = (String) claims.get("scope");
        return ResponseEntity.ok("Hello " + username + " with " + scope);
    }



    @PostMapping("/create")
    public ResponseEntity<String> createHotel(@RequestBody @Valid CreateHotelDTO createHotel, Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String role = authorities.toString();
        hotelService.createHotel(createHotel, authentication.getName(), role);
        return ResponseEntity.ok("Hotel created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DetailHotelDTO> updateHotel(@RequestParam Long id, Authentication authentication, UpdateHotelDTO updateHotel ) {
        String name = authentication.getName();
        DetailHotelDTO update = hotelService.update(id, updateHotel, name);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@RequestParam Long id, Authentication authentication) {
        String name = authentication.getName();
        hotelService.deleteHotelById(id, name);
        return ResponseEntity.ok("Hotel deleted successfully");
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ROLE_MANAGER')")
    public ResponseEntity<List<DetailHotelDTO>> getAllHotels(Authentication authentication) {
        List<DetailHotelDTO> allByManager = hotelService.getAllByManager(authentication.getName());
        return ResponseEntity.ok(allByManager);
    }
}
