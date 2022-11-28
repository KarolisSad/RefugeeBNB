package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.daoInterfaces.HostDaoInterface;
import via.sep3.group11.tier2.daoInterfaces.HousingDaoInterface;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.HostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.domain.Address;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

/**
 * Class implementing HostInterface.
 * Class is implemented with @Service-annotation to mark it as a Spring-component.
 * @see via.sep3.group11.tier2.logicInterfaces.HostInterface
 * @version 27/11-2022
 * @author Group 11
 */
@Service
public class HostLogic implements HostInterface {

    private HostDaoInterface hostDAO;
    private HousingDaoInterface housingDAO;

    /**
     * Simple constructor used to inject the two DAO's needed for communicating with the data-tier.
     * @param hostDAO: Data Access Object used for accessing Host-information in the data-tier.
     * @param housingDAO: Data Access Object used for accessing Housing-information in the data-tier.
     */
    public HostLogic(HostDaoInterface hostDAO, HousingDaoInterface housingDAO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
    }

    /**
     * Implementation of method used to create a new host in the data-tier.
     * This is implemented by creating an empty Host-object, and adding all information stored in the DTO to this, by using the set methods specified.
     * @see Host for documentation of set methods.
     * @param dto: a Domain Transfer Object containing all relevant attributes needed to create a new Host.
     * @return An object representation of the newly created Host-entry in the data-tier.
     * @throws NotUniqueException: If a host-entry with an identical email is already present in the data-tier.
     * @throws ValidationException: If any of the validation checks on the values ion the DTO fails.
     */
    @Override
    public Host RegisterHost(HostRegisterDTO dto) throws NotUniqueException, ValidationException {
        try {
            Host toRegister = new Host();

            toRegister.setEmail(dto.getEmail());
            toRegister.setPassword(dto.getPassword());
            toRegister.setGender(dto.getGender());
            toRegister.setNationality(dto.getNationality());
            toRegister.setFirstName(dto.getFirstName());
            toRegister.setMiddleName(Optional.ofNullable(dto.getMiddleName()));
            toRegister.setLastName(dto.getLastName());
            toRegister.setDateOfBirth(dto.getDateOfBirth());

            Optional<Host> existing = hostDAO.GetHostByEmail(toRegister.getEmail());

            if (existing.isPresent()) {
                throw new NotUniqueException("Host with email " + existing.get().getEmail() + " already exists.");
            }

            return hostDAO.CreateHost(toRegister);
        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

    /**
     * Implementation of method used to log in an already existing host.
     * This is implemented by creating an empty Host-object, and adding the email and password information from the DTO to it.
     * A call is then made to the data-tier to find a host with the specified email.
     * If such a Host is found, it is verified that the password given in the DTO matches the password stored.
     * @param dto: A domain transfer object containing the email and password of the host trying to log in.
     * @return An object representation of the logged in host gotten from the Data-tier.
     * @throws ValidationException if any of the validation specified above fails.
     */
    @Override
    public Host LoginHost(LoginDTO dto) throws ValidationException {
        try {
            Host toLogin = new Host();
            toLogin.setEmail(dto.getEmail());
            toLogin.setPassword(dto.getPassword());

            Optional<Host> loggedIn = hostDAO.GetHostByEmail(toLogin.getEmail());

            if (loggedIn.isEmpty()) {
                throw new NullPointerException("Host with email " + toLogin.getEmail() + " not found.");
            }

            if (!(toLogin.getPassword().equals(loggedIn.get().getPassword()))) {
                throw new ValidationException("Password incorrect.");
            }

            return loggedIn.get();

        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

    /**
     * Implementation of method used to add a new housing to a host.
     * This is implemented by getting the Host specified in the DTO from the data-tier.
     * After this, a new Address-object is created by passing along the information from the DTO.
     * This address, along with the capacity stored in the DTO is used to create a new Housing-object, which is then passed along to the Housing DAO, and the response from this is returned.
     * @param dto: a domain transfer object containing all relevant attributes about the housing to add (including address), and the email of the owner of the housing.
     * @return A housing object representing the newly added entry in the Data-tier.
     * @throws ValidationException if any validation of the housing throws an exception.
     * @throws IllegalArgumentException if the host specified in the DTO does not exist.
     */
    @Override
    public Housing AddHousing(HousingCreationDTO dto) throws ValidationException {
        try {
            Optional<Host> owner = hostDAO.GetHostByEmail(dto.getHostEmail());

            if (owner.isEmpty()) {
                throw new IllegalArgumentException("Host with email: " + dto.getHostEmail() + " not found.");
            }

            Address address = new Address(dto.getCountry(), dto.getCity(), dto.getStreetName(),
                    dto.getHouseNumber(), dto.getRoomNumber(), dto.getPostCode());

            Housing toCreate = new Housing(dto.getCapacity(), address);

            return housingDAO.AddHousing(toCreate, owner.get().getEmail());
        }

        catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }
}
