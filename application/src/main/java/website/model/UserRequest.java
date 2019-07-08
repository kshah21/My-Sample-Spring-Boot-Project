package website.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
    private final String name;
    private final UserType userType;

    public UserRequest(String name, UserType userType) {
        this.name = name;
        this.userType = userType;
    }

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonGetter
    public UserType getUserType() {
        return userType;
    }
}
