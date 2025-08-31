package vn.edu.hust.registration_login_system.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.hust.registration_login_system.dto.UserDto;
import vn.edu.hust.registration_login_system.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/reg")
    public String registerPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "reg-page";
    }

    @PostMapping("/reg/save")
    public String saveRegistrationForm(@Valid @ModelAttribute("user") UserDto userDto,
                                       BindingResult bindingResult, Model model){
        if(userService.existsByEmail(userDto.getEmail()) && userService.findByEmail(userDto.getEmail()) != null){
            bindingResult.rejectValue("email", null, "E-mail has already existed");
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user", userDto);
            return "reg-page";
        }
        userService.saveUser(userDto);
        return "redirect:/reg?success";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users-list";
    }
}
