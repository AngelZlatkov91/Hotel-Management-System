package Hotel.management.hotel.management.Service;

import Hotel.management.hotel.management.Entitys.DTO.CreateHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Entitys.Model.Hotel;
import Hotel.management.hotel.management.Repositoriy.HotelRepositories;
import Hotel.management.hotel.management.Repositoriy.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepositories hotelRepositories;
    private final UserRepositories userRepositories;

    public HotelServiceImpl(HotelRepositories hotelRepositories, UserRepositories userRepositories) {
        this.hotelRepositories = hotelRepositories;
        this.userRepositories = userRepositories;
    }

    @Override
    public List<DetailHotelDTO> getAllHotels() {
       return hotelRepositories.findAll().stream().map(this::mapToDTO).toList();
    }
    private DetailHotelDTO mapToDTO(Hotel hotel) {
        DetailHotelDTO detailHotelDTO = new DetailHotelDTO();


        return detailHotelDTO;
    }

    @Override
    public DetailHotelDTO getHotelById(Long id) {
        return null;
    }

    @Override
    public void deleteHotelById(Long id, String email) {

    }

    @Override
    public void createHotel(CreateHotelDTO dto, String email) {

    }
}
