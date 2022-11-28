package via.sep3.group11.tier3.services.serviceImp;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Housing;
import via.sep3.group11.tier3.repository.HousingRepository;
import via.sep3.group11.tier3.services.servicesInterfaces.HousingDaoInterface;

/**
 * A class that implements housingDaoInterface
 * and initializes HousingRepository in order to manipulate
 * the database on the housing table.
 * In the class Service annotation is used in order to mark the class as
 * service provider for some business functionality.
 *
 * @version 28/11/22
 * @author Group 11
 */
@Service
public class HousingService implements HousingDaoInterface {

    private HousingRepository repository;

    /**
     * Constructor to initialize repository class
     * @param repository housing repository
     */
    public HousingService(HousingRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that creates new address object in the database,
     * using JpaRepository (CrudRepository) method
     * @param housing housing object
     * @param email id
     * @return created housing object
     */
    @Override
    public Housing addHousing(Housing housing, String email) {
        return repository.save(housing);
    }
}
