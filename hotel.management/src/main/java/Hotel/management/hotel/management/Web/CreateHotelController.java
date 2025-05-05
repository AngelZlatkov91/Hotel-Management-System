package Hotel.management.hotel.management.Web;

import Hotel.management.hotel.management.Entitys.Model.Hotel;
import Hotel.management.hotel.management.Service.HotelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel/create")
public class CreateHotelController {
    private final HotelService hotelService;

    public CreateHotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<String> createHotel(@RequestBody @Valid CreateHotelController createHotel) {

        return ResponseEntity.ok("Hotel created successfully");
    }
}
