package User.management.user.management.Models.DTO;

import User.management.user.management.Models.Enum.Role;

public class UserChangeRoleDTO {
    private String email;
    private Role role;
    public UserChangeRoleDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
