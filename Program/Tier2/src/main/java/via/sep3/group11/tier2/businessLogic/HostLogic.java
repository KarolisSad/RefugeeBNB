package via.sep3.group11.tier2.businessLogic;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.HostDTO;
import via.sep3.group11.tier2.shared.DTOs.HostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.HostUpdateDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.domain.Agreement;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Housing;

import java.util.List;
import java.util.Optional;

/**
 * Class implementing HostInterface.
 * Class is implemented with @Service-annotation to mark it as a Spring-component.
 * @see via.sep3.group11.tier2.logicInterfaces.HostInterface
 * @version 12-12-2022
 * @author Group 11
 */
@Service
public class HostLogic implements HostInterface {

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementCommunicationInterface;
    private PasswordEncoder passwordEncoder;

    /**
     *
     * All-argument constructor used to inject the two DAO's needed for communicating with the data-tier.
     * @param hostDAO: Data Access Object used for accessing Host-information in the data-tier.
     * @param housingDAO: Data Access Object used for accessing Housing-information in the data-tier.
     * @param agreementCommunicationInterface Data Access Object used for accessing Agreement-information in the data-tier.
     */
    public HostLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO, AgreementCommunicationInterface agreementCommunicationInterface, PasswordEncoder passwordEncoder) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
        this.agreementCommunicationInterface = agreementCommunicationInterface;
        this.passwordEncoder = passwordEncoder;
    }



    /**
     * Implementation of method used to find a host by housing id as the method implies.
     * In the method, the housing referenced in the methods argument is placed in a new object
     * and is checked if it is empty. If empty a HostDTO is returned that only contain the error message
     * otherwise we return HostDTO that fulfils the initial argument with the error message set to empty.
     * @param housingId housing ID that is used as a reference to find a host.
     * @return HostDTO
     */
    @Override
    public HostDTO getHostByHousingId(long housingId) {
        Optional<Housing> housing = housingDAO.getHousingById(housingId);
        if (housing.isEmpty())
        {
            return new HostDTO(null,"This housing no longer exists.");
        }
        return new HostDTO(hostDAO.getHostByHousingId(housingId).get(),"");
    }

    /**
     * Implementation of the method used to delete a host account
     * In the method, new host object is created where the referenced object from the given email
     * address is put in. In order to check if the account exists, the object is checked if empty and
     * if yes a DTO with only an error is sent.
     * If the host object is not empty, there may be agreements and housing associated with the host, therefore
     * a check is done through all agreements and if there are any accepted (active), a new DTO is sent with an error message
     * otherwise we remove any pending agreements and housing and finally the host.
     * @param email the email of the host that is required to be deleted.
     * @return HostDTO
     */
    @Override
    public HostDTO deleteAccount(String email) {

        Optional<Host> existing = hostDAO.getHostByEmail(email);
        if (existing.isEmpty())
        {
            return new HostDTO(null, "Host with email: " + email + " not found, and therefore unable to be deleted.");
        }

        // If host is existing - get lists of agreements and housings.
        List<Agreement> agreementList = agreementCommunicationInterface.getAgreementsByHostId(email);
        List<Housing> housingList = housingDAO.getAllHousingByHostId(email);

        // if any agreement is accepted - do not delete, instead return a dto with error message.
        for (Agreement a : agreementList) {
            if (a.isAccepted()) {
                return new HostDTO(null, "Unable to delete. Ongoing agreement(s) found.");
            }
        }

        // remove all pending agreements
        for (Agreement a : agreementList) {
            agreementCommunicationInterface.deleteAgreement(a.getAgreementId());
        }

        // remove all housing
        for (Housing h : housingList) {
            housingDAO.removeHousing(h.getHousingId());
        }

        // delete host entity
        hostDAO.deleteAccount(email);

        return new HostDTO(null, "");
    }

    /**
     * Implementation of the method used to update host personal information.
     * In the method, new host object is created where the referenced object from the given email
     * address is put in. In order to check if the account exists, the object is checked if empty and
     * if yes a DTO with only an error is sent.
     * If the dto is not empty there is multiple checks made in order to make sure that needed personal data
     * is not empty and if so an error message is sent
     * otherwise new data is set.
     * @param dto a DTO object that contains new updated data
     * @return HostDTO
     */
    @Override
    public HostDTO updateInformation(HostUpdateDTO dto) {
        Optional<Host> host = hostDAO.getHostByEmail(dto.getEmail());
        if(host.isEmpty())
        {
            return new HostDTO(null, "The host with the given email does not exist.");
        }

            Host toBeUpdated = host.get();
            if (!dto.getFirstName().isBlank()) {
                toBeUpdated.setFirstName(dto.getFirstName());
                System.out.println("UPDATING FIRST NAME");
            }

            toBeUpdated.setMiddleName(dto.getMiddleName());
            System.out.println("UPDATING MIDDLE NAME");

            if (!dto.getLastName().isBlank()) {
                toBeUpdated.setLastName(dto.getLastName());
                System.out.println("UPDATING LAST NAME");
            }
            if (!dto.getPassword().isBlank()) {
                toBeUpdated.setPassword(passwordEncoder.encode(dto.getPassword()));
                System.out.println("UPDATING PASSWORD");
            }
            toBeUpdated.setGender(dto.getGender());
            System.out.println("UPDATING GENDER");
            if (!dto.getNationality().isBlank()) {
                toBeUpdated.setNationality(dto.getNationality());
                System.out.println("UPDATING NATIONALITY");
            }

            Host updated = hostDAO.updateInformation(toBeUpdated);

            return new HostDTO(updated, "");
        }

    /**
     * Implementation of method used to find a host by hosts email as the method implies.
     * In the method, the host with referenced email in the methods argument is placed in a new object
     * and is checked if it is empty. If empty a HostDTO is returned that only contain the error message
     * otherwise we return HostDTO that fulfils the initial argument with the error message set to empty.
     * @param email hosts email that is used as a reference to find a host.
     * @return HostDTO
     */
    @Override
    public HostDTO getHostById(String email) {
        Optional<Host> host = hostDAO.getHostByEmail(email);
        if (host.isEmpty()) {
            return new HostDTO(null, "Host with this email can not be found.");
        }
        return new HostDTO(host.get(), "");
    }

}
