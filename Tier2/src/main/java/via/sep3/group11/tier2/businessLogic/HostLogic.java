package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Agreement;
import via.sep3.group11.tier2.shared.domain.Date;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.List;
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

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementCommunicationInterface;

    /**
     * Simple constructor used to inject the two DAO's needed for communicating with the data-tier.
     * @param hostDAO: Data Access Object used for accessing Host-information in the data-tier.
     * @param housingDAO: Data Access Object used for accessing Housing-information in the data-tier.
     */
    public HostLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO, AgreementCommunicationInterface agreementCommunicationInterface) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
        this.agreementCommunicationInterface = agreementCommunicationInterface;
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
    public HostDTO registerHost(HostRegisterDTO dto) {
            Host toRegister = new Host(dto.getFirstName(), dto.getEmail(), dto.getPassword(), dto.getGender(), dto.getNationality(), dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth());
        System.out.println("TEST: " + toRegister.getGender());


        // host check
            Optional<Host> existing = hostDAO.getHostByEmail(toRegister.getEmail());

        // if no host found - create
        return existing.map
                (host -> new HostDTO(toRegister, "Host with email " + host.getEmail() + " already exists."))
                .orElseGet(() -> new HostDTO(hostDAO.createHost(toRegister), ""));


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
    public HostDTO loginHost(LoginDTO dto) {
            Host dummyHost = new Host("dummyHost","dummyHost@gmail.com","DummyHost", 'O',"DummyHost","DummyHost","DummyHost", new Date(01,01,2021));

        // host check
        Optional<Host> host = hostDAO.getHostByEmail(dto.getEmail());
        if (host.isEmpty())
        {
            return new HostDTO(dummyHost, "Host with email " + host.get().getEmail() + " doesn't exist.");
        }

        // username & password check
        if (dto.getPassword().equals(host.get().getPassword()))
        {
            return new HostDTO(host.get(),"");
        }
            return new HostDTO(dummyHost,"Password is incorrect");
    }

    @Override
    public HostDTO getHostByHousingId(long housingId) {
        Host dummyHost = new Host("dummyHost","dummyHost@gmail.com","DummyHost", 'O',"DummyHost","DummyHost","DummyHost", new Date(01,01,2021));

        System.out.println("getHostByID Test: " + housingId);
        // housing check
        Optional<Housing> housing = housingDAO.getHousingById(housingId);
        if (housing.isEmpty())
        {
            return new HostDTO(dummyHost,"This housing no longer exists.");
        }
        return new HostDTO(hostDAO.getHostByHousingId(housingId).get(),"");
    }

    @Override
    public HostDTO deleteAccount(String email) {

        Optional<Host> existing = hostDAO.getHostByEmail(email);
        if (existing.isEmpty())
        {
            return new HostDTO(null, "Host with email: " + email + " not found, and therefore unable to be deleted.");
        }

        // If host is existing - get lists of agreements and housings.
        List<Agreement> agreementList = agreementCommunicationInterface.getAgreementsByHostId(email);
        List<Housing> housingList = housingDAO.getAllHousingByHostId(email); //TODO

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
        hostDAO.deleteAccount(email); //TODO

        return new HostDTO(null, "");
    }

}
