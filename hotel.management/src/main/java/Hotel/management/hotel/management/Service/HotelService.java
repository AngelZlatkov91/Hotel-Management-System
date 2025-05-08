package Hotel.management.hotel.management.Service;

import Hotel.management.hotel.management.Entitys.DTO.CreateHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.UpdateHotelDTO;

import java.util.List;

public interface HotelService {

    List<DetailHotelDTO> getAllHotels();

    DetailHotelDTO getHotelById(Long id );

    void deleteHotelById(Long id , String email);

    void createHotel (CreateHotelDTO dto , String email);

    DetailHotelDTO update(Long id, UpdateHotelDTO updateHotel, String name);

    List<DetailHotelDTO> getAllByManager(String name);
}
