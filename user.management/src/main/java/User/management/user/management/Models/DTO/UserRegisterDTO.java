package User.management.user.management.Models.DTO;

import User.management.user.management.Validation.PasswordMatch;
import User.management.user.management.Validation.UniqueUserEmail;
import User.management.user.management.Validation.UniqueUserPhone;
import jakarta.validation.constraints.*;

@PasswordMatch(first = "password",
second = "confirmPassword")
public class UserRegisterDTO {
    @NotBlank
    @UniqueUserEmail
    @Email
    private  String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    @UniqueUserPhone
    private String phone;
    @Positive
    private int age;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(int age, String email, String password, String phone, String username, String confirmPassword) {
        this.age = age;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.confirmPassword = confirmPassword;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
