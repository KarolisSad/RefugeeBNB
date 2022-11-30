package via.sep3.group11.tier3.DAO.DAOInterfaces;

import via.sep3.group11.tier3.model.Housing;

import java.util.List;

public interface HousingDaoInterface {

    Housing addHousing(Housing housing, String email);
    List<Housing> getAvailableHousing();
    void removeHousing(long housingId);
}
