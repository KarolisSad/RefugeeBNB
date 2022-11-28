package via.sep3.group11.tier3.services.serviceImp;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Refugee;
import via.sep3.group11.tier3.repository.RefugeeRepository;
import via.sep3.group11.tier3.services.servicesInterfaces.RefugeeDaoInterface;

import java.util.Optional;

@Service
public class RefugeeService implements RefugeeDaoInterface {

    private RefugeeRepository repository;

    public RefugeeService(RefugeeRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @param refugee
     * @return
     */
    @Override
    public Refugee createRefugee(Refugee refugee) {
        return repository.save(refugee);
    }

    @Override
    public Optional<Refugee> getRefugeeByEmail(String email) {
        return repository.findById(email);
    }
}
