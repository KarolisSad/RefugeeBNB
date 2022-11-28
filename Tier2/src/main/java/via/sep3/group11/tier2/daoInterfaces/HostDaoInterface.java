package via.sep3.group11.tier2.daoInterfaces;


import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface HostDaoInterface {
    Host CreateHost(Host host) throws ValidationException;
    Optional<Host> GetHostByEmail(String email) throws ValidationException;
}
