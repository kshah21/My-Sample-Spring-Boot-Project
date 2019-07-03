package library.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
    private final String name;
    private final UserType userType;

    @JsonCreator
    public UserRequest(
            @JsonProperty("name") String name,
            @JsonProperty("userType") UserType userType) {
        this.name = name;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }
}
