package via.sep3.group11.tier2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JwtAuthEntryPoint authEntryPoint;
    private CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtAuthEntryPoint authEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.authEntryPoint = authEntryPoint;
    }

    // Todo probably some filtering errors here. Test everything :-)
    //The filterchain intercepts requests before they hit controllers.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable() // Disable csrf-tokens as we are using JWT instead.
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint) // add jwt authentication entry-point
            .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // make sessions stateless, as we are using jwt
            .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // All auth endpoints requests are allowed for everyone.
                .antMatchers("/api/refugee/**").hasAuthority("REFUGEE") // Only refugees have access to anything under /refugee
                .antMatchers(HttpMethod.GET, "api/host/**").authenticated()
                .antMatchers(HttpMethod.POST, "api/hosts/**").hasAuthority("HOST")
                .antMatchers(HttpMethod.DELETE, "api/hosts/**").hasAuthority("HOST")
                .antMatchers(HttpMethod.POST, "/api/housing").hasAuthority("HOST") // Only hosts can post housing
                .antMatchers(HttpMethod.POST, "/api/housing/delete").hasAuthority("HOST") // Only hosts can delete housing
                .antMatchers("/api/agreements/**").authenticated()
                .anyRequest().authenticated() // Any other request must be authenticated
                .and()
                .httpBasic(); // Use http
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    /*
    @Bean
    public HttpFirewall configureFirewall() {
        StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
        strictHttpFirewall
                .setAllowedHeaderNames((header) -> true);
        strictHttpFirewall
                .setAllowedHeaderValues((header) -> true);
        strictHttpFirewall
                .setAllowedParameterNames((parameter) -> true);
        strictHttpFirewall
                .setUnsafeAllowAnyHttpMethod(true);

        return strictHttpFirewall;
    }

     */
}


