package via.sep3.group11.tier2.businessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.AuthInterface;
import via.sep3.group11.tier2.shared.DTOs.NewRefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;

@Service
public class AuthLogic implements AuthInterface {

    private RefugeeCommunicationInterface refugeeCommunication;
    private HostCommunicationInterface hostCommunicationInterface;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthLogic(RefugeeCommunicationInterface refugeeCommunication,
                     HostCommunicationInterface hostCommunicationInterface,
                     PasswordEncoder passwordEncoder) {
        this.refugeeCommunication = refugeeCommunication;
        this.hostCommunicationInterface = hostCommunicationInterface;
        this.passwordEncoder = passwordEncoder;
    }


    //TODO NEW FOR TESTING AUTH
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
    public boolean existsByEmail(String email) {
        return (refugeeCommunication.getRefugeeByEmail(email).isPresent() ||
                hostCommunicationInterface.getHostByEmail(email).isPresent());
    }
}
