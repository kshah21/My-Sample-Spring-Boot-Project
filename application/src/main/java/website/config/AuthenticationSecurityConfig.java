package website.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import website.service.MyUserDetailsService;

@Configuration
public class AuthenticationSecurityConfig extends GlobalAuthenticationConfigurerAdapter {
    private final MyUserDetailsService userDetailsService;

    public AuthenticationSecurityConfig(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
