package via.sep3.group11.tier2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Refugee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private HostCommunicationInterface hostCommunicationInterface;
    private RefugeeCommunicationInterface refugeeCommunicationInterface;

    @Autowired
    public CustomUserDetailsService(HostCommunicationInterface hostCommunicationInterface,
                                    RefugeeCommunicationInterface refugeeCommunicationInterface) {
        this.hostCommunicationInterface = hostCommunicationInterface;
        this.refugeeCommunicationInterface = refugeeCommunicationInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Host> host = hostCommunicationInterface.getHostByEmail(username);
        Optional<Refugee> refugee = refugeeCommunicationInterface.getRefugeeByEmail(username);

            if (host.isEmpty() && refugee.isEmpty()) {
                throw new UsernameNotFoundException("User with email: " + username + " not found!");
            }
            return host.map(value -> new User(value.getEmail(), value.getPassword(),
                            mapRoleToAuthorities("HOST")))
                    .orElseGet(() -> new User(refugee.get().getEmail(), refugee.get().getPassword(),
                            mapRoleToAuthorities("REFUGEE")));
    }

    private Collection<GrantedAuthority> mapRoleToAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}
