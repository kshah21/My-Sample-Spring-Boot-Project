package library.web.controller;

import library.model.User;
import library.model.UserRequest;
import library.model.UserType;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(
            @RequestBody final UserRequest request,
            @Value("${my-env}") String myEnv,
            @Value("${spring.profiles.active}") String activeProfile
    ) {
        System.out.println("Active Profile:" + activeProfile);
        System.out.println("My Env:" + myEnv);
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

    @PostMapping("/get-user")
    public ResponseEntity<User> getUser(@RequestBody final UserRequest userRequest) {
        return userService.getUser(userRequest)
                .map(userEntity -> ResponseEntity.ok().body(userEntity))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/get-random/{name}")
    public ResponseEntity<User> getRandomUserWithName(@PathVariable final String name) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new User(new Long("21"),name, "", "", UserType.REGULAR));
    }
}
