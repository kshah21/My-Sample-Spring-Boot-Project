package library.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
    private final String name;
    private final String password;
    private final UserType userType;

    @JsonCreator
    public UserRequest(
            @JsonProperty("name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("userType") UserType userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
