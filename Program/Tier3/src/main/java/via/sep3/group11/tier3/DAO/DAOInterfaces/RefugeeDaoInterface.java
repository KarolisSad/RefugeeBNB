package via.sep3.group11.tier3.DAO.DAOInterfaces;

import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Refugee;

import java.util.Optional;

public interface RefugeeDaoInterface {

    Refugee createRefugee (Refugee refugee);
    Optional<Refugee> getRefugeeByEmail (String email);
    void deleteAccount(String email);
    Refugee updateInformation(Refugee refugee);
}
