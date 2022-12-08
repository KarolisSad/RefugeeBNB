package via.sep3.group11.tier2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.shared.domain.Host;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/*
@Service
public class CustomHostDetailsService implements UserDetailsService {

    private HostCommunicationInterface hostCommunicationInterface;

    @Autowired
    public CustomHostDetailsService(HostCommunicationInterface hostCommunicationInterface) {
        this.hostCommunicationInterface = hostCommunicationInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Host host = hostCommunicationInterface.getHostByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with id: " + username + " not found."));

        return new User(host.getEmail(), host.getPassword(), mapRoleToAuthorities("HOST"));
    }


    private Collection<GrantedAuthority> mapRoleToAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}


 */