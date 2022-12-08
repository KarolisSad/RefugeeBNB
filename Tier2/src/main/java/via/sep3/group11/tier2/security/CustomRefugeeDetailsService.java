package via.sep3.group11.tier2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.shared.domain.Refugee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
@Service
public class CustomRefugeeDetailsService implements UserDetailsService {

    private RefugeeCommunicationInterface refugeeCommunicationInterface;

    @Autowired
    public CustomRefugeeDetailsService(RefugeeCommunicationInterface refugeeCommunicationInterface) {
        this.refugeeCommunicationInterface = refugeeCommunicationInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Refugee refugee = refugeeCommunicationInterface.getRefugeeByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with id: " + username + " not found."));
        System.out.println(refugee.getEmail() + " found");
        return new User(refugee.getEmail(), refugee.getPassword(), mapRoleToAuthorities());
    }


    private Collection<GrantedAuthority> mapRoleToAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("REFUGEE"));
        return authorities;
    }
}

 */
