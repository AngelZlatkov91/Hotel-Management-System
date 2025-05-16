package Hotel.management.hotel.management.Web;


import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DetailHotelDTO>> getAllHotels() {
     return ResponseEntity.ok(service.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailHotelDTO> getHotelByID(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHotelById(id));
    }


}
