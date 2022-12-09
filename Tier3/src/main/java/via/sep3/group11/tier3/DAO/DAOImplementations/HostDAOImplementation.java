package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;
import via.sep3.group11.tier3.repository.HostRepository;
import via.sep3.group11.tier3.DAO.DAOInterfaces.HostDaoInterface;
import via.sep3.group11.tier3.repository.HousingRepository;
import java.util.Optional;

/**
 * A class that implements HostDaoInterface
 * and initializes HostRepository in order to manipulate
 * the database on the host table.
 * In the class Service annotation is used in order to mark the class as
 * service provider for some business functionality.
 *
 * @version 28/11/22
 * @author Group 11
 */
@Service
public class HostDAOImplementation implements HostDaoInterface {

    private HostRepository hostRepository;
    private HousingRepository housingRepository;

    public HostDAOImplementation(HostRepository hostRepository, HousingRepository housingRepository) {
        this.hostRepository = hostRepository;
        this.housingRepository = housingRepository;
    }

    /**
     * Method that creates new address object in the database,
     * using JpaRepository (CrudRepository) method
     * @param host address object
     * @return created host object
     */
    @Override
    public Host createHost(Host host) {

        Host newHost = hostRepository.save(host);

        return hostRepository.save(host);
    }

    /**
     * Method that calls a host object by email(id), using JpaRepository (CrudRepository) method.
     * @param email id
     * @return host object if it exists, otherwise it returns an Optional object.
     */
    @Override
    public Optional<Host> getHostByEmail(String email) {
        return hostRepository.findById(email);
    }

    @Override
    public Optional<Host> getHostByHousingId(long id) {

        Optional<Housing> housing = housingRepository.findById(id);

        if (housing.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(housing.get().host);
    }

    @Override
    public void deleteAccount(String email) {
        hostRepository.deleteById(email);
        //hostRepository.deleteHostByEmail(email);
    }

    @Override
    public Host updateInformation(Host host) {
        if (hostRepository.findById(host.getEmail()).isPresent()) {
            return hostRepository.save(host);
        }
        return null;
    }

}
