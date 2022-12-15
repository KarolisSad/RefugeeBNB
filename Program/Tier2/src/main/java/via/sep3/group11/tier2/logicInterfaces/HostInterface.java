package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.*;
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

    HostDTO getHostByHousingId (long housingId);
    HostDTO deleteAccount(String email);
    HostDTO updateInformation(HostUpdateDTO dto);
    HostDTO getHostById(String email);
}

