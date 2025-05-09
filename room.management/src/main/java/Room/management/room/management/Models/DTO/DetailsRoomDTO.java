package Room.management.room.management.Models.DTO;

import Room.management.room.management.Models.RoomStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DetailsRoomDTO {
    private Long id;
    private String roomNumber;
    private String type;
    private int capacity;
    private boolean available;
    private BigDecimal pricePerNight;
    private String description;
    private String floor;
    private RoomStatus status;
    private Long hotelId;

    private List<String> images;


    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
