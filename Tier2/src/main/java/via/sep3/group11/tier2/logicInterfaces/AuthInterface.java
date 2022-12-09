package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.*;

public interface AuthInterface {
    RefugeeDTO registerRefugee(NewRefugeeRegisterDTO dto);
    HostDTO registerHost(NewHostRegisterDTO dto);
    boolean existsByEmail(String email);
    AuthResponseDTO login(LoginDTO loginDTO);
}
