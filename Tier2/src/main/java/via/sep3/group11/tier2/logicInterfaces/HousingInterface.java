package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingIdDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingListDTO;

public interface HousingInterface {
    HousingDTO addHousing(HousingCreationDTO dto);
    HousingListDTO getAvailableHousing();
    HousingDTO removeHousing(HousingIdDTO dto);
}
