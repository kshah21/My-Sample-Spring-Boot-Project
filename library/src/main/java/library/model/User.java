package library.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class User {
    private Long id;
    private final String name;
    private final String password;
    private final String email;
    private final UserType userType;

    public User(Long id, String name, String password, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
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
    public String getEmail() {
        return email;
    }

    @JsonGetter
    public UserType getUserType() {
        return userType;
    }

    @JsonGetter
    public Long getId() {
        return id;
    }
}
