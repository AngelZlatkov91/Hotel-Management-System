package Hotel.management.hotel.management.Entitys.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_hotel_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false, unique = true)
    private String email;

    public User() {
    }

    public User(Long id, String role, String email) {
        this.id = id;

        this.role = role;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
