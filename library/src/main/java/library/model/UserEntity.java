package library.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_record", schema = "user_db")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserEntity() {
    }

    public UserEntity(String name, String password, String email, UserType userType) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    @Column(name="userType")
    public UserType getUserType() {
        return userType;
    }

    @Column(name="id")
    public Long getId() {
        return id;
    }
}
