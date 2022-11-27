package via.sep3.group11.tier2.daoInterfaces;

import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

public interface HostDaoInterface {
    Host CreateHost(Host host) throws ValidationException;
    Host GetHostByEmail(String email) throws ValidationException;
}
