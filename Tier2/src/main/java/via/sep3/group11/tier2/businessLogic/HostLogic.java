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

@Service
public class HostLogic implements HostInterface {

    private HostDaoInterface hostDAO;
    private HousingDaoInterface housingDAO;

    public HostLogic(HostDaoInterface hostDAO, HousingDaoInterface housingDAO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
    }

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

            Optional<Host> existing = hostDAO.getHostByEmail(toRegister.getEmail());

            if (existing.isPresent()) {
                throw new NotUniqueException("Host with email " + existing.get().getEmail() + " already exists.");
            }

            return hostDAO.createHost(toRegister);
        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

    @Override
    public Host LoginHost(LoginDTO dto) throws ValidationException {
        try {
            Host toLogin = new Host();
            toLogin.setEmail(dto.getEmail());
            toLogin.setPassword(dto.getPassword());

            Optional<Host> loggedIn = hostDAO.getHostByEmail(toLogin.getEmail());

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

    @Override
    public Housing AddHousing(HousingCreationDTO dto) throws ValidationException {
        try {
            Optional<Host> owner = hostDAO.getHostByEmail(dto.getHostEmail());

            if (owner.isEmpty()) {
                throw new IllegalArgumentException("Host with email: " + dto.getHostEmail() + " not found.");
            }

            Address address = new Address(dto.getCountry(), dto.getCity(), dto.getStreetName(),
                    dto.getHouseNumber(), dto.getRoomNumber(), dto.getPostCode());

            Housing toCreate = new Housing(dto.getCapacity(), address);

            return housingDAO.addHousing(toCreate, owner.get().getEmail());
        }

        catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }
}
