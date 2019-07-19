package website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import website.model.LoginRequest;
import website.model.User;
import website.service.UserService;

import static website.model.UserType.ADMIN;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping("/success")
    public RedirectView loginSuccess(RedirectAttributes attributes){
        attributes.addAttribute("test", "shouldBeQueryParam");
        attributes.addFlashAttribute("username", "username");
        attributes.addFlashAttribute("userType", "userType");
        attributes.addFlashAttribute("email", "email");
        attributes.addFlashAttribute("id", "id");
        return new RedirectView("regularHome");
    }

    @GetMapping("/adminHome")
    public String adminPage() {
        return "adminHome";
    }

    @GetMapping("/regularHome")
    public ModelAndView regularPage(
            ModelMap model,
            @ModelAttribute("username") Object username,
            @ModelAttribute("userType") Object userType,
            @ModelAttribute("email") Object email,
            @ModelAttribute("id") Object id
    ) {
        model.addAttribute("username", username);
        model.addAttribute("userType", userType);
        model.addAttribute("email", email);
        model.addAttribute("id", id);
        return new ModelAndView("regularHome", model);
    }
}
