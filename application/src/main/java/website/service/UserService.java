package website.service;

import org.springframework.stereotype.Component;
import website.client.UserClient;
import website.model.LoginRequest;
import website.model.User;
import website.model.UserRequest;

import static website.model.UserType.ADMIN;
import static website.model.UserType.REGULAR;

@Component
public class UserService {

    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public User createUser(LoginRequest loginRequest) {
        final UserRequest userRequest;
        if(loginRequest.getUsername().contains("admin")) {
            userRequest = new UserRequest(loginRequest.getUsername(), loginRequest.getPassword(), ADMIN);
        } else {
            userRequest = new UserRequest(loginRequest.getUsername(), loginRequest.getPassword(), REGULAR);
        }
        return userClient.createUser(userRequest);
    }

    public User getUserById(String id) {
        return userClient.getUser(id);
    }

    public User getUserByName(String username) {
        return userClient.getUser(new UserRequest(username, "", REGULAR));
    }
}
