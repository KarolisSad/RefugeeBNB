package via.sep3.group11.tier2.CommunicationInterfaces;


import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.List;

public interface HousingCommunicationInterface {
    Housing addHousing(Housing housing, String email) throws ValidationException;
    List<Housing> getAvailableHousing();
    void removeHousing(long housingId);
    Housing getHousingById(long housingId);
    Housing updateHousing (Housing housing);
}
