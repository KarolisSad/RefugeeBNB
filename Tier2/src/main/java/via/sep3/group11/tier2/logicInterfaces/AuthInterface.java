package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.NewRefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;

public interface AuthInterface {
    //TODO NEW FOR TESTING AUTH
    String newRegisterRefugee(NewRefugeeRegisterDTO dto);
    boolean existsByEmail(String email);
}
