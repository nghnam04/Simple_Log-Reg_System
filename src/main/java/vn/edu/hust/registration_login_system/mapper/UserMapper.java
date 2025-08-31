package vn.edu.hust.registration_login_system.mapper;

import vn.edu.hust.registration_login_system.dto.UserDto;
import vn.edu.hust.registration_login_system.entity.User;

import java.util.Arrays;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        String[] str = user.getName().trim().split(" ");
        String firstName = str.length > 0 ? str[0] : "";
        String lastName  = str.length > 1 ? String.join(" ", Arrays.copyOfRange(str, 1, str.length)) : "";

        UserDto userDto = new UserDto(
                user.getId(),
                firstName,
                lastName,
                user.getEmail(),
                user.getPassword()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        String fullName = userDto.getFirstName();
        if(userDto.getLastName() != null && !userDto.getLastName().isEmpty()){
            fullName += " " + userDto.getLastName();
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(fullName);
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
