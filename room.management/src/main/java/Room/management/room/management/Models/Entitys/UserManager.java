package Room.management.room.management.Models.Entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "user_manager")
public class UserManager extends BaseEntity {



    @Column(nullable = false,unique = true)
    private String email;
    @Column (nullable = false)
    private String role;

    public UserManager() {
    }

    public UserManager(String email, String role) {
        this.email = email;
        this.role = role;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
