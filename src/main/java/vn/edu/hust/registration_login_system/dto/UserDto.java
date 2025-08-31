package vn.edu.hust.registration_login_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "First Name must not be empty")
    private String firstName;

    @NotEmpty(message = "Last Name must not be empty")
    private String lastName;

    @NotEmpty(message = "E-mail must not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password must not be empty")
    private String password;

}
