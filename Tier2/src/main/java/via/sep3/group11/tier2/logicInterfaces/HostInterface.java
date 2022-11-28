package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.HostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

/**
 * Interface with methods representing actions that can be made by a Host in the system.
 * This interface is to be implemented in a way, so business logic is applied to the calls made from the application-tier
 * before they are passed on to the data-tier.
 * All methods are to be called from the Application-tier, and can be seen as a way of controlling access to the data-tier.
 * @version 27/11-2022
 * @author Group 11
 */
public interface HostInterface {
    /**
     * Method used to register a new host in the system.
     * The implementation of this should perform relevant business logic on the call, and return a Host-object from the Data tier.
     * @param dto: a Domain Transfer Object containing all relevant attributes needed to create a new Host.
     * @return The created host object.
     * @throws NotUniqueException: If the host specified by the DTO is already present in the Data tier.
     * @throws ValidationException: If any of the information in the DTO fails validation.
     */
    Host registerHost(HostRegisterDTO dto) throws NotUniqueException, ValidationException;
    /**
     * Method used to login an already existing host.
     * The implementation of this should validate the information in the DTO, and return an object representation of the Host logging in.
     * @param dto: A domain transfer object containing the email and password of the host trying to log in.
     * @return An object representation of the host logged in.
     * @throws ValidationException if no Host corresponding to the email in the dto is found, or if the password and email given does not match.
     */
    Host loginHost(LoginDTO dto) throws ValidationException;

    /**
     * Method used to add a housing object to the system.
     * @param dto: a domain transfer object containing all relevant attributes about the housing to add (including address), and the email of the owner of the housing.
     * @return An object representation of the Housing created.
     * @throws ValidationException if any validation of the domain transfer object fails.
     */
    Housing addHousing(HousingCreationDTO dto) throws ValidationException;
}

