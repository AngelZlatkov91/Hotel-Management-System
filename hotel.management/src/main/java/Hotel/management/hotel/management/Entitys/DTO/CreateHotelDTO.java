package Hotel.management.hotel.management.Entitys.DTO;
import Hotel.management.hotel.management.Validation.UniqueHotelEmail;
import Hotel.management.hotel.management.Validation.UniqueHotelName;
import Hotel.management.hotel.management.Validation.UniqueHotelPhone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateHotelDTO {
    @NotBlank
    @UniqueHotelName
    private String name;
    @NotBlank
    private String city;
    @NotBlank
    private String address;
    @NotBlank
    @UniqueHotelPhone
    private String phone;
    @NotBlank
    @Email
    @UniqueHotelEmail
    private String email;
    @Positive
    @Size(min = 1,max = 5)
    private int stars;
    @NotBlank
    private String description;

    public CreateHotelDTO() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
