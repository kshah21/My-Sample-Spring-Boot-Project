package library.service;

import library.model.User;
import library.model.UserEntity;
import library.model.UserRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    private final CrudRepository<UserEntity, Long> userRepository;

    public UserService(CrudRepository<UserEntity, Long> userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> createUser(final UserRequest userRequest) {
        return !alreadyExists(userRequest)
                ? Optional.of(createUserFrom(userRepository.save(createUserEntityFrom(userRequest))))
                : Optional.empty();
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id).map(this::createUserFrom);
    }

    public Optional<User> getUser(final UserRequest requestedUser) {
        for (UserEntity userEntity : userRepository.findAll()) {
            if (userEntity.getName().equals(requestedUser.getName())) {
                return Optional.of(createUserFrom(userEntity));
            }
        }
        return Optional.empty();
    }

    private Boolean alreadyExists(final UserRequest requestedUser) {

        for (UserEntity userEntity : userRepository.findAll()) {
            if (userEntity.getName().equals(requestedUser.getName())) {
                return true;
            }
        }
        return false;
    }

    private UserEntity createUserEntityFrom(final UserRequest userRequest) {
        return new UserEntity(
                userRequest.getName(),
                userRequest.getPassword(),
                String.format("%s@super.com", userRequest.getName()),
                userRequest.getUserType()
        );
    }

    private User createUserFrom(final UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getUserType()
        );
    }
}
