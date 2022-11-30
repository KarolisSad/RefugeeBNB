package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.repository.AddressRepository;
import via.sep3.group11.tier3.DAO.DAOInterfaces.AddressDaoInterface;

/**
 * A class that implements AddressDaoInterface
 * and initializes AddressRepository in order to manipulate
 * the database on the address table.
 * In the class Service annotation is used in order to mark the class as
 * service provider for some business functionality.
 *
 * @version 28/11/22
 * @author Group 11
 */
@Service
public class AddressDAOImplementation implements AddressDaoInterface {

    private AddressRepository repository;

    /**
     * Constructor to initialize repository class
     * @param repository address repository
     */
    public AddressDAOImplementation(AddressRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that creates new address object in the database,
     * using JpaRepository (CrudRepository) method
     * @param address address object
     * @param housingId housing id
     * @return created address object
     */
    @Override
    public Address addAddress(Address address, long housingId) {
        return repository.save(address);
    }
}
