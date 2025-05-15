package Room.management.room.management.Service;

import Room.management.room.management.Models.DTO.AllImagesDTO;
import Room.management.room.management.Models.DTO.ImagesDTO;

import java.util.List;

public interface ImagesService {

    void addImagesToHotelRooms(AllImagesDTO allImagesDTO, Long id);

    List<ImagesDTO> getAllImagesDTO(Long id);

    void deleteImages(Long id);

}
