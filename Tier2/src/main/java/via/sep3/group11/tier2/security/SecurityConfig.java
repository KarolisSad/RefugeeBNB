package via.sep3.group11.tier2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CustomRefugeeDetailsService refugeeDetailsService;
    private CustomHostDetailsService hostDetailsService;

    @Autowired
    public SecurityConfig(CustomRefugeeDetailsService refugeeDetailsService,
                          CustomHostDetailsService hostDetailsService) {
        this.refugeeDetailsService = refugeeDetailsService;
        this.hostDetailsService = hostDetailsService;
    }

    //The filterchain intercepts requests before they hit controllers.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable csrf-tokens as we are using JWT instead.
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // All auth endpoints requests are allowed for everyone.
                .antMatchers("/api/refugee/**").hasRole("REFUGEE")
                .antMatchers("/api/host/**").hasRole("HOST")
                .anyRequest().authenticated() // Any other request must be authenticated
                .and()
                .httpBasic(); // Use http

        return http.build();
    }

    //TODO USER ROLES??? NEEDED???? IN DATABASE CHECK VIDEO "REGISTER"

    // IN MEMORY -> TO BE DELETED!
    /*
    @Bean
    public UserDetailsService users() {
        UserDetails host = User.builder()
                .username("host")
                .password("password")
                .roles("HOST")
                .build();

        UserDetails refugee = User.builder()
                .username("refugee")
                .password("password")
                .roles("REFUGEE")
                .build();

        return new InMemoryUserDetailsManager(host, refugee);
    }

     */

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
}


