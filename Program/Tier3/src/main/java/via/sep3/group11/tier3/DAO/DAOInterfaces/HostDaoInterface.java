package via.sep3.group11.tier3.DAO.DAOInterfaces;

import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.Optional;

public interface HostDaoInterface {

    Host createHost (Host host);
    Optional<Host> getHostByEmail(String email);
    Optional<Host> getHostByHousingId(long id);
    void deleteAccount(String email);
    Host updateInformation(Host host);
}
