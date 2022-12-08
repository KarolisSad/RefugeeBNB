package via.sep3.group11.tier2.businessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.AuthInterface;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.NewHostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.NewRefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Refugee;

@Service
public class AuthLogic implements AuthInterface {

    private RefugeeCommunicationInterface refugeeCommunication;
    private HostCommunicationInterface hostCommunicationInterface;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authManager;

    @Autowired
    public AuthLogic(RefugeeCommunicationInterface refugeeCommunication,
                     HostCommunicationInterface hostCommunicationInterface,
                     PasswordEncoder passwordEncoder, AuthenticationManager authManager) {
        this.refugeeCommunication = refugeeCommunication;
        this.hostCommunicationInterface = hostCommunicationInterface;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
    }


    @Override
    public String newRegisterRefugee(NewRefugeeRegisterDTO dto) {


        Refugee toRegister = new Refugee(dto.getEmail(), passwordEncoder.encode(dto.getPassword()),
                dto.getGender(), dto.getNationality(),
                dto.getFirstName(), dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth(),
                dto.getFamilySize(), dto.getDescription());

        refugeeCommunication.createRefugee(toRegister);
        return "Registration successful";
    }

    @Override
    public String registerHost(NewHostRegisterDTO dto) {

        Host toRegister = new Host(dto.getFirstName(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()),
                dto.getGender(), dto.getNationality(),
                dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth());

        hostCommunicationInterface.createHost(toRegister);
        return "Registration successful";
    }

    @Override
    public boolean existsByEmail(String email) {
        return (refugeeCommunication.getRefugeeByEmail(email).isPresent() ||
                hostCommunicationInterface.getHostByEmail(email).isPresent());
    }

    @Override
    public String login(LoginDTO loginDTO) {
            Authentication authentication =
                    authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
                            loginDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        return "Login success!";
    }
}
