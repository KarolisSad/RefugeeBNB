package via.sep3.group11.tier2.daoInterfaces;


import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public interface HostDaoInterface {
    Host createHost(Host host) throws ValidationException;
    Optional<Host> getHostByEmail(String email) throws ValidationException;
}
