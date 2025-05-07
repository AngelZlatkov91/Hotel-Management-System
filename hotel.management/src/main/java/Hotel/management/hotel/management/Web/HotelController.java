package Hotel.management.hotel.management.Web;


import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @GetMapping("/roles")
    public ResponseEntity<?> roles (Authentication authentication) {
        Object principal = authentication.getPrincipal();

        return ResponseEntity.ok(authentication.getAuthorities());
    }

    @GetMapping
    public ResponseEntity<List<DetailHotelDTO>> getAllHotels() {
     return ResponseEntity.ok(service.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailHotelDTO> getHotelById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getHotelById(id));
    }

}
