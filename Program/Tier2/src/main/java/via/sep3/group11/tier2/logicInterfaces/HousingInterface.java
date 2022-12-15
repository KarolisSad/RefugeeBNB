package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

public interface HousingInterface {
    HousingDTO addHousing(HousingCreationDTO dto);
    HousingListDTO getAvailableHousing();
    HousingDTO removeHousing(HousingIdDTO dto);
    HousingListDTO getHousingByHostId(String email);


}
