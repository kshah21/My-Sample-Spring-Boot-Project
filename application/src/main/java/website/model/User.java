package website.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Long id;
    private final String name;
    private final String password;
    private final String email;
    private final UserType userType;

    @JsonCreator
    public User(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("userType") UserType userType
    ) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public Long getId() {
        return id;
    }
}
