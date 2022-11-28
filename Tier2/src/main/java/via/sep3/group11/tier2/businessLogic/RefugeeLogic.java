package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.daoInterfaces.RefugeeDaoInterface;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

/**
 * Class implementing RefugeeInterface
 * Class is implented with @Service-annotation to mark it as a Spring-component.
 * @see via.sep3.group11.tier2.logicInterfaces.RefugeeInterface
 * @version 27/11-2022
 * @author Group 11
 */
@Service
public class RefugeeLogic implements RefugeeInterface {

    private RefugeeDaoInterface refugeeDAO;

    /**
     * Constructor used to inject the DAO needed for communicating with the data-tier.
     * @param refugeeDAO: Data Access Object used access Refugee information from the Data-tier.
     */
    public RefugeeLogic(RefugeeDaoInterface refugeeDAO) {
        this.refugeeDAO = refugeeDAO;
    }

    /**
     * Implementation of method used to create a new refugee in the data-tier.
     * This is implemented by creating an empty Refugee-object, and adding all information stored in the DTO to this, by using the set methods specified.
     * @see Refugee for documentation of set methods.
     * @param dto: a Domain Transfer Object containing all relevant attributes needed to create a new Refugee.
     * @return An object representation of the newly created Refugee-entry in the data-tier.
     * @throws NotUniqueException: If a refugee-entry with an identical email is already present in the data-tier.
     * @throws ValidationException: If any of the validation checks on the values ion the DTO fails.
     */
    @Override
    public Refugee RegisterRefugee(RefugeeRegisterDTO dto) throws NotUniqueException, ValidationException {
        try {
            Refugee toRegister = new Refugee();

            toRegister.setEmail(dto.getEmail());
            toRegister.setPassword(dto.getPassword());
            toRegister.setGender(dto.getGender());
            toRegister.setNationality(dto.getNationality());
            toRegister.setFirstName(dto.getFirstName());
            toRegister.setMiddleName(Optional.ofNullable(dto.getMiddleName()));
            toRegister.setLastName(dto.getLastName());
            toRegister.setDateOfBirth(dto.getDateOfBirth());

            Optional<Refugee> existing = refugeeDAO.GetRefugeeByEmail(toRegister.getEmail());

            if (existing.isPresent()) {
                throw new NotUniqueException("Refugee with email " + existing.get().getEmail() + " already exists.");
            }

            return refugeeDAO.CreateRefugee(toRegister);

        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

    /**
     * Implementation of method used to log in an already existing Refugee.
     * This is implemented by creating an empty Refugee-object, and adding the email and password information from the DTO to it.
     * A call is then made to the data-tier to find a refugee with the specified email.
     * If such a refugee is found, it is verified that the password given in the DTO matches the password stored.
     * @param dto: A domain transfer object containing the email and password of the refugee trying to log in.
     * @return An object representation of the logged in refugee gotten from the Data-tier.
     * @throws ValidationException if any of the validation specified above fails.
     */
    @Override
    public Refugee LoginRefugee(LoginDTO dto) throws ValidationException {
        try {
            Refugee toLogin = new Refugee();

            toLogin.setEmail(dto.getEmail());
            toLogin.setPassword(dto.getPassword());

            Optional<Refugee> loggedIn = refugeeDAO.GetRefugeeByEmail(toLogin.getEmail());

            if (loggedIn.isEmpty()) {
                throw new NullPointerException("Refugee with email " + toLogin.getEmail() + " not found.");
            }

            if (!(toLogin.getPassword().equals(loggedIn.get().getPassword()))) {
                throw new ValidationException("Password incorrect.");
            }

            return loggedIn.get();

        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

}
