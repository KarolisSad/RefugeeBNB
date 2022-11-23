package via.sep3.group11.tier3.services.serviceImp;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Housing;
import via.sep3.group11.tier3.repository.HousingRepository;
import via.sep3.group11.tier3.services.servicesInterfaces.HousingDaoInterface;

@Service
public class HousingService implements HousingDaoInterface {

    private HousingRepository repository;

    public HousingService(HousingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Housing addHousing(Housing housing, String email) {
        return repository.save(housing);
    }
}
