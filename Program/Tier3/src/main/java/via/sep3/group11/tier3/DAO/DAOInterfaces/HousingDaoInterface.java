package via.sep3.group11.tier3.DAO.DAOInterfaces;

import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.List;
import java.util.Optional;

public interface HousingDaoInterface {

    Housing addHousing(Housing housing, String email);
    Optional<Housing> getHousingById(long housingId);
    Housing updateHousing(Housing housing);
    List<Housing> getAvailableHousing();
    void removeHousing(long housingId);
    List<Housing> getAllHousingByHostId(String hostEmail);
}
