package website.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class UserRequest {
    private final String name;
    private final String password;
    private final UserType userType;

    public UserRequest(String name, String password, UserType userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonGetter
    public String getPassword() {
        return password;
    }

    @JsonGetter
    public UserType getUserType() {
        return userType;
    }
}
