package via.sep3.group11.tier2.daoInterfaces;

import via.sep3.group11.tier2.shared.domain.Host;

import java.util.Optional;

public interface HostDaoInterface {
    Host createHost(Host host);
    Optional<Host> getHostByEmail(String email);
}
