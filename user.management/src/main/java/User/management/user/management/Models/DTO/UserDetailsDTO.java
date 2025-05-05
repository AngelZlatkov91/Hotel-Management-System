package User.management.user.management.Models.DTO;

public class UserDetailsDTO {

    private Long id;
    private String email;
    private  String username;
    private String phone;
    private int age;
    private String role;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(int age, String email, Long id, String phone, String username, String role) {
        this.age = age;
        this.email = email;
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
