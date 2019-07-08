package website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import website.client.UserClient;
import website.model.LoginRequest;
import website.model.User;
import website.model.UserRequest;
import website.model.UserType;
import website.service.UserService;

import static website.model.UserType.ADMIN;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model){
        final User newUser = userService.createUser(loginRequest);
        model.addAttribute("username", newUser.getName());
        model.addAttribute("userType", newUser.getUserType().toString());
        model.addAttribute("email", newUser.getEmail());
        model.addAttribute("id", newUser.getId());
        return newUser.getUserType() == ADMIN ? "adminHome" : "regularHome";
    }
}
