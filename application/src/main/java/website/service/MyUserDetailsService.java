package website.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import website.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.getUserByName(username);
        if(user == null) {
            return null;
        }
        return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(user.getName())
                .password(user.getPassword())
                .roles(user.getUserType().toString())
                .build();
    }
}
