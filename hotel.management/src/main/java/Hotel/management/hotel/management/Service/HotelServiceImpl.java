package Hotel.management.hotel.management.Service;
import Hotel.management.hotel.management.Entitys.DTO.CreateHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.DetailHotelDTO;
import Hotel.management.hotel.management.Entitys.DTO.UpdateHotelDTO;
import Hotel.management.hotel.management.Entitys.Model.Hotel;
import Hotel.management.hotel.management.Entitys.Model.User;
import Hotel.management.hotel.management.Repositoriy.HotelRepositories;
import Hotel.management.hotel.management.Repositoriy.UserRepositories;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        detailHotelDTO.setId(hotel.getId());
        detailHotelDTO.setName(hotel.getName());
        detailHotelDTO.setAddress(hotel.getAddress());
        detailHotelDTO.setCity(hotel.getCity());
        detailHotelDTO.setEmail(hotel.getEmail());
        detailHotelDTO.setPhone(hotel.getPhone());
        detailHotelDTO.setStars(hotel.getStars());
        return detailHotelDTO;
    }

    @Override
    public DetailHotelDTO getHotelById(Long id) {
        Optional<Hotel> byId = hotelRepositories.findById(id);
        return byId.map(this::mapToDTO).orElse(null);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id, String email) {
        hotelRepositories.findById(id).ifPresent(hotel -> {
          if (hotel.getUser().getEmail().equals(email)) {
           hotelRepositories.delete(hotel);
          }
        });
    }

    @Override
    public void createHotel(CreateHotelDTO dto, String email, String role) {

        if (userRepositories.findByEmail(email).isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setRole(role);
            userRepositories.save(newUser);
        }
        Optional<User> byEmail = userRepositories.findByEmail(email);

        Hotel hotel = mapToCreate(dto);
        hotel.setUser(byEmail.orElse(new User()));
        hotelRepositories.save(hotel);
    }

    private Hotel mapToCreate(CreateHotelDTO dto) {
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setDescription(dto.getDescription());
        hotel.setEmail(dto.getEmail());
        hotel.setAddress(dto.getAddress());
        hotel.setCity(dto.getCity());
        hotel.setPhone(dto.getPhone());
        hotel.setStars(dto.getStars());
        return hotel;
    }

    @Override
    @Transactional
    public DetailHotelDTO update(Long id, UpdateHotelDTO updateHotel, String name) {
        return null;
    }

    @Override
    public List<DetailHotelDTO> getAllByManager(String name) {
        Optional<User> byEmail = userRepositories.findByEmail(name);
      return   hotelRepositories.findAllByUser(byEmail.get()).stream().map(this::mapToDTO).toList();
    }
}
