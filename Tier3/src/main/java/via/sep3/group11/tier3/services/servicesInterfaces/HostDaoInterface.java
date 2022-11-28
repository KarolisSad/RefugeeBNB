package via.sep3.group11.tier3.services.servicesInterfaces;

import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.Optional;

public interface HostDaoInterface {

    Host createHost (Host host);
    Optional<Host> getHostByEmail(String email);
}
