package via.sep3.group11.tier3.services.serviceImp;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.repository.HostRepository;
import via.sep3.group11.tier3.services.servicesInterfaces.HostDaoInterface;

import java.util.Optional;

@Service
public class HostService implements HostDaoInterface {

    private HostRepository repository;

    public HostService(HostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Host createHost(Host host) {
        return repository.save(host);
    }

    @Override
    public Optional<Host> getHostByEmail(String email) {
        return repository.findById(email);
    }
}
