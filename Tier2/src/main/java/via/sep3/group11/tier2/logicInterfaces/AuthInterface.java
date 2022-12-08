package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.AuthResponseDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.NewHostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.NewRefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;

public interface AuthInterface {
    //TODO NEW FOR TESTING AUTH
    String newRegisterRefugee(NewRefugeeRegisterDTO dto);
    String registerHost(NewHostRegisterDTO dto);
    boolean existsByEmail(String email);
    String login(LoginDTO loginDTO);
}
