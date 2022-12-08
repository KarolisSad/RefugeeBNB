package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.AuthResponseDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.NewHostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.NewRefugeeRegisterDTO;

public interface AuthInterface {
    String registerRefugee(NewRefugeeRegisterDTO dto);
    String registerHost(NewHostRegisterDTO dto);
    boolean existsByEmail(String email);
    AuthResponseDTO login(LoginDTO loginDTO);
}
