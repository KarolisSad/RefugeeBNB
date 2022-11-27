package via.sep3.group11.tier2.logicInterfaces;


import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

public interface RefugeeInterface {
    Refugee RegisterRefugee(RefugeeRegisterDTO dto) throws NotUniqueException, ValidationException;
    Refugee LoginRefugee(LoginDTO dto) throws ValidationException;
}

