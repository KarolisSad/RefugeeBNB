package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Refugee;
import via.sep3.group11.tier3.repository.RefugeeRepository;
import via.sep3.group11.tier3.DAO.DAOInterfaces.RefugeeDaoInterface;
import java.util.Optional;

/**
 * A class that implements RefugeeDaoInterface
 * and initializes refugeeRepository in order to manipulate
 * the database on the refugee table.
 * In the class Service annotation is used in order to mark the class as
 * service provider for some business functionality.
 *
 * @version 28/11/22
 * @author Group 11
 */
@Service
public class RefugeeDAOImplementation implements RefugeeDaoInterface {

    private RefugeeRepository repository;

    /**
     * Constructor to initialize repository class
     * @param repository refugee repository
     */
    public RefugeeDAOImplementation(RefugeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that creates new refugee object in the database,
     * using JpaRepository (CrudRepository) method
     * @param refugee refugee object
     * @return created refugee object
     */
    @Override
    public Refugee createRefugee(Refugee refugee) {
        return repository.save(refugee);
    }

    /**
     * Method that calls a refugee object by email(id), using JpaRepository (CrudRepository) method.
     * @param email id
     * @return refugee object if it exists, otherwise it returns an optional object.
     */
    @Override
    public Optional<Refugee> getRefugeeByEmail(String email) {
        return repository.findById(email);
    }

    @Override
    public void deleteAccount(String email) {

        repository.deleteById(email);
        //repository.deleteByEmail(email);
    }

    @Override
    public Refugee updateInformation(Refugee refugee) {
        if (repository.findById(refugee.getEmail()).isPresent()) {
            System.out.println("UPDATING!");
            return repository.save(refugee);
        }
        return null;
    }
}
