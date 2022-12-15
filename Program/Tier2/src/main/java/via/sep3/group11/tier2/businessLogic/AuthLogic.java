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
import via.sep3.group11.tier2.security.JWTGenerator;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Refugee;

@Service
public class AuthLogic implements AuthInterface {

    private RefugeeCommunicationInterface refugeeCommunication;
    private HostCommunicationInterface hostCommunicationInterface;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authManager;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthLogic(RefugeeCommunicationInterface refugeeCommunication,
                     HostCommunicationInterface hostCommunicationInterface,
                     PasswordEncoder passwordEncoder, AuthenticationManager authManager,
                     JWTGenerator jwtGenerator) {
        this.refugeeCommunication = refugeeCommunication;
        this.hostCommunicationInterface = hostCommunicationInterface;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtGenerator = jwtGenerator;
    }


    @Override
    public RefugeeDTO registerRefugee(NewRefugeeRegisterDTO dto) {


        Refugee toRegister = new Refugee(dto.getEmail(), passwordEncoder.encode(dto.getPassword()),
                dto.getGender(), dto.getNationality(),
                dto.getFirstName(), dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth(),
                dto.getFamilySize(), dto.getDescription());

        Refugee created = refugeeCommunication.createRefugee(toRegister);
        return new RefugeeDTO(created, "");
    }

    @Override
    public HostDTO registerHost(NewHostRegisterDTO dto) {

        Host toRegister = new Host(dto.getFirstName(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()),
                dto.getGender(), dto.getNationality(),
                dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth());

        Host created = hostCommunicationInterface.createHost(toRegister);
        return new HostDTO(created, "");
    }

    @Override
    public boolean existsByEmail(String email) {
        return (isHost(email) ||
                isRefugee(email));
    }

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
            Authentication authentication =
                    authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
                            loginDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String role = "";
            if (isHost(loginDTO.getEmail())) {
                role = "HOST";
            } else if (isRefugee(loginDTO.getEmail())) {
                role = "REFUGEE";
            }
        String token = jwtGenerator.generateToken(authentication, role);

            return new AuthResponseDTO(token);
    }

    private boolean isHost(String email) {
        return hostCommunicationInterface.getHostByEmail(email).isPresent();
    }

    private boolean isRefugee(String email) {
        return refugeeCommunication.getRefugeeByEmail(email).isPresent();
    }
}
