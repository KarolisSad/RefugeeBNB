package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.AgreementInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.*;
import java.util.List;
import java.util.Optional;

/**
 * Class implementing AgreementInterface.
 * Class is implemented with @Service-annotation to mark it as a Spring-component.
 * @see via.sep3.group11.tier2.logicInterfaces.HostInterface
 * @version 12-12-2022
 * @author Group 11
 */
@Service
public class AgreementLogic implements AgreementInterface {

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementDAO;
    private RefugeeCommunicationInterface refugeeDAO;

    /**
     * All-argument constructor used to inject the three DAO's needed for communicating with the data-tier.
     * @param hostDAO: Data Access Object used for accessing Host-information in the data-tier.
     * @param housingDAO: Data Access Object used for accessing Housing-information in the data-tier.
     * @param agreementDAO Data Access Object used for accessing Agreement-information in the data-tier.
     * @param refugeeDAO Data Access Object used for accessing Refugee-information in the data-tier.
     */
    public AgreementLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO, AgreementCommunicationInterface agreementDAO, RefugeeCommunicationInterface refugeeDAO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
        this.agreementDAO = agreementDAO;
        this.refugeeDAO = refugeeDAO;
    }

    /**
     * Implementation of a method that is meant to request housing by the refugee and creation of the agreement.
     * In the method, the given dto in an argument contains a host reference and using that a host object is created to check if the given
     * host is not empty otherwise the error message inside a dto is sent. Likewise, is done with a housing as well as
     * the housing is checked if it's available. If the checks are passed a new argument is created and sent to the database.
     * @param dto agreement dto that contains reference to host, refugee, housing and an error message that is initially set to empty string.
     * @return AgreementDTO
     */
    @Override
    public AgreementDTO requestAgreement(RequestAgreementDTO dto) {
        // Host check
        Optional<Host> host = hostDAO.getHostByEmail(dto.getHostEmail());
        if (host.isEmpty())
        {
            return new AgreementDTO(null, "Owner of this housing deactivated his account and this housing is no longer available");
        }
        // Housing check
        Optional<Housing> housing = housingDAO.getHousingById(dto.getHousing().getHousingId());

        if (housing.isEmpty())
        {
            return new AgreementDTO(null, "This housing is no longer listed.");
        }
        if (!housing.get().isAvailable())
        {
            return new AgreementDTO(null, "This housing is already reserved.");
        }
        Optional<Refugee> refugee = refugeeDAO.getRefugeeByEmail(dto.getRefugeeEmail());

        // Create agreement
        Agreement agreementToCreate = new Agreement(host.get(),housing.get(),refugee.get());
        Agreement createdAgreement = agreementDAO.addAgreement(agreementToCreate);
        return new AgreementDTO(createdAgreement,"");
    }

    /**
     * Implementation of a method that is meant to respond to a request for a new agreement with either accepted or not status.
     * In the method, a new agreement object is created that contains a referenced object from RequestAgreementDTO. A isEmpty check
     * is made as well as isAccepted and if it's not empty and accepted the agreement status is changed and saved in the database.
     * otherwise the agreement is deleted.
     * @param dto an object that contains agreement Id, status and error message set to empty string.
     * @return AgreementDTO
     */
    @Override
    public AgreementDTO respondToAgreement(RespondAgreementDTO dto) {
        // Agreement check
        Optional<Agreement> agreement = agreementDAO.getAgreementById(dto.getAgreementId());
        if (agreement.isEmpty())
        {
            return new AgreementDTO(null,"This agreement no longer exists");
        }
        else if (dto.isAccepted())
        {
            //Update housing
            Optional<Housing> updatedHousing = housingDAO.getHousingById(agreement.get().getHousing().getHousingId());
            updatedHousing.get().setAvailable(false);
            housingDAO.updateHousing(updatedHousing.get());

            // Update agreement
            agreement.get().setAccepted(true);
            agreementDAO.updateAgreement(agreement.get());
            return new AgreementDTO(agreement.get(),"");
        }
        else {
            // Delete agreement
            agreementDAO.deleteAgreement(agreement.get().getAgreementId());
            //todo check for testing
            Optional <Housing> housing = housingDAO.getHousingById(agreement.get().getHousing().getHousingId());
            housing.get().setAvailable(true);

            housingDAO.updateHousing(housing.get());
            return new AgreementDTO(agreement.get(), "");
        }
    }

    /**
     * Implementation of a method that is meant to get all agreements that are pending status of not accepted.
     * In the method, a new agreement list is created that has a reference to a specific host email.
     * @param dto dto that contains host email and error message
     * @return
     */
    @Override
    public AgreementListDTO getAllRequestsByHost(AgreementsByHostDTO dto) {
        List<Agreement> a = agreementDAO.getAgreementsByHostId(dto.getHostEmail());
        AgreementListDTO agreementListDTO = new AgreementListDTO(a, "");
        return agreementListDTO;
    }

    @Override
    public AgreementDTO getAgreementByRefugeeEmail(String refugeeEmail) {
        Optional<Agreement> agreement = agreementDAO.getAgreementByRefugeeEmail(refugeeEmail);

        if (agreement.isPresent()) {
            return new AgreementDTO(agreement.get(), "");
        }

        return new AgreementDTO(null, "No confirmed agreement found");
    }
}
