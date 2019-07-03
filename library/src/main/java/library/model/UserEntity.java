package library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private UserType userType;

    public UserEntity() {
    }

    public UserEntity(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public String getName() {
        return name;
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
