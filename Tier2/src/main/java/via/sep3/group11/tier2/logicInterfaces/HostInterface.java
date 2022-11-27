package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.HostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;


public interface HostInterface {
    Host RegisterHost(HostRegisterDTO dto) throws NotUniqueException, ValidationException;
    Host LoginHost(LoginDTO dto) throws ValidationException;
    Housing AddHousing(HousingCreationDTO dto) throws ValidationException;
}

