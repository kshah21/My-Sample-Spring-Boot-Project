package library.web.controller;

import library.model.User;
import library.model.UserRequest;
import library.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody final UserRequest request) {
        return userService.createUser(request)
                .map(userEntity -> ResponseEntity.accepted().body(userEntity))
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/get-user")
    public ResponseEntity<User> getUser(@RequestParam final Long id) {
        return userService.getUser(id)
                .map(userEntity -> ResponseEntity.ok().body(userEntity))
                .orElse(ResponseEntity.noContent().build());
    }
}
