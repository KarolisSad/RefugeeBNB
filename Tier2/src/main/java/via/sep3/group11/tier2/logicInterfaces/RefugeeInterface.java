package via.sep3.group11.tier2.logicInterfaces;


import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

/**
 * Interface with methods representing actions that can be made by a Refugee in the system.
 * This interface is to be implemented in a way, so business logic is applied to the calls made from the application-tier
 * before they are passed on to the data-tier.
 * All methods are to be called from the Application-tier, and can be seen as a way of controlling access to the data-tier.
 * @version 27/11-2022
 * @author Group 11
 */
public interface RefugeeInterface {
    /**
     * Method used to register a new refugee in the system.
     * The implementation of this should perform relevant business logic on the call, and return a refugee-object from the Data tier.
     * @param dto: a Domain Transfer Object containing all relevant attributes needed to create a new refugee.
     * @return The created refugee object.
     * @throws NotUniqueException: If the host specified by the DTO is already present in the Data tier.
     * @throws ValidationException: If any of the information in the DTO fails validation.
     */
    Refugee registerRefugee(RefugeeRegisterDTO dto) throws NotUniqueException, ValidationException;
    /**
     * Method used to login an already existing refugee.
     * The implementation of this should validate the information in the DTO, and return an object representation of the refugee logging in.
     * @param dto: A domain transfer object containing the email and password of the refugee trying to log in.
     * @return An object representation of the refugee logged in.
     * @throws ValidationException if no refugee corresponding to the email in the dto is found, or if the password and email given does not match.
     */
    Refugee loginRefugee(LoginDTO dto) throws ValidationException;
}

