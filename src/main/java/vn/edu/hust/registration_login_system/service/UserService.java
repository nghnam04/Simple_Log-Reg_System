package vn.edu.hust.registration_login_system.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.registration_login_system.constant.RoleEnum;
import vn.edu.hust.registration_login_system.dto.UserDto;
import vn.edu.hust.registration_login_system.entity.Role;
import vn.edu.hust.registration_login_system.entity.User;
import vn.edu.hust.registration_login_system.mapper.UserMapper;
import vn.edu.hust.registration_login_system.repository.RoleRepository;
import vn.edu.hust.registration_login_system.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public void saveUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findByName(RoleEnum.STUDENT);
        if(role == null){
            role = checkRoleExists();
        }

        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    public Role checkRoleExists(){
        Role role = new Role();
        role.setName(RoleEnum.STUDENT);
        return roleRepository.save(role);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }
}
