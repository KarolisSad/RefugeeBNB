package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.model.Agreement;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;
import via.sep3.group11.tier3.repository.AddressRepository;
import via.sep3.group11.tier3.repository.HostRepository;
import via.sep3.group11.tier3.repository.HousingRepository;
import via.sep3.group11.tier3.DAO.DAOInterfaces.HousingDaoInterface;

import java.util.List;
import java.util.Optional;

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
public class HousingDAOImplementation implements HousingDaoInterface {

    private HousingRepository repository;
    private AddressRepository addressRepository;
    private HostRepository hostRepository;

    /**
     * Constructor to initialize repository class
     * @param repository housing repository
     */
    public HousingDAOImplementation(HousingRepository repository, AddressRepository addressRepository, HostRepository hostRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.hostRepository = hostRepository;
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
        Address a = housing.getAddress();
        addressRepository.save(a);

        Housing toAdd = housing;
        System.out.println("TEST AVAILABLITIY: " + toAdd.isAvailable());
        Optional<Host> host = hostRepository.findById(email);

        if (host.isPresent()) {
            toAdd.host = host.get();
            return repository.save(toAdd);
        }

        return null;
    }


    @Override
    public Optional<Housing> getHousingById(long housingId) {
        return repository.findById(housingId);
    }

    /**
     * Method used for updating an existing housing entity in the database.
     * This is done by taking an updated version of the housing entity as an argument (the actual updating is done in the logic tier).
     * The repository then checks if the housing actually exists in the database, and then pverwrites it with the updated version.
     * @param housing The updated housing object used to overwrite the already existing entity in the database.
     * @return The updated housing entity from the database after the update is done, or null if no entity with a matching id is found.
     */
    @Override
    public Housing updateHousing(Housing housing) {

        Optional<Housing> existing = repository.findById(housing.getHousingId());
        if (existing.isPresent()) {
            Housing toUpdate = existing.get();
            Host host = toUpdate.host;
            toUpdate = housing;
            toUpdate.host = host;

            repository.save(toUpdate);
        }
        /*
        if (repository.findById(housing.getHousingId()).isPresent()) {
            return repository.save(housing);
        }
         */

        return null;
    }

    @Override
    public List<Housing> getAvailableHousing() {

        return repository.findAllByAvailableTrue();
    }

    @Override
    public void removeHousing(long housingId) {
        repository.deleteById(housingId);
    }

    @Override
    public List<Housing> getAllHousingByHostId(String email) {
        return repository.findAllByHost_Email(email);
    }
}
