package Hotel.management.hotel.management.Web;

import Hotel.management.hotel.management.Entitys.DTO.CreateHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.UpdateHotelDTO;
import Hotel.management.hotel.management.Service.HotelService;
import Hotel.management.hotel.management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/hotel/manager")
public class ManagerController {


    private final HotelService hotelService;
    private final UserService userService;

    public ManagerController(HotelService hotelService, UserService userService) {
        this.hotelService = hotelService;
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createHotel(@RequestBody @Valid CreateHotelDTO createHotel, Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String role = authorities.toString();
        userService.addUserForCreateHotel(authentication.getName(), role);
        hotelService.createHotel(createHotel,authentication.getName());
        return ResponseEntity.ok("Hotel created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DetailHotelDTO> updateHotel(@PathVariable Long id, Authentication authentication, UpdateHotelDTO updateHotel ) {
        String name = authentication.getName();
        DetailHotelDTO update = hotelService.update(id, updateHotel, name);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id, Authentication authentication) {
        String name = authentication.getName();
        hotelService.deleteHotelById(id, name);
        return ResponseEntity.ok("Hotel deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<DetailHotelDTO>> getAllHotels(Authentication authentication) {
        List<DetailHotelDTO> allByManager = hotelService.getAllByManager(authentication.getName());
        return ResponseEntity.ok(allByManager);
    }
}
