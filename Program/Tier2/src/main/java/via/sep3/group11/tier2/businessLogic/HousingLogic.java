package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.HousingInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Address;
import via.sep3.group11.tier2.shared.domain.Housing;

import java.util.List;
import java.util.Optional;

/**
 * Class implementing HousingInterface.
 * Class is implemented with @Service-annotation to mark it as a Spring-component.
 * @see via.sep3.group11.tier2.logicInterfaces.HostInterface
 * @version 12-12-2022
 * @author Group 11
 */
@Service
public class HousingLogic implements HousingInterface {

    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementDAO;

    /**
     * All-argument constructor used to inject the three DAO's needed for communicating with the data-tier.
     * @param housingDAO: Data Access Object used for accessing Housing-information in the data-tier.
     * @param agreementDAO Data Access Object used for accessing Agreement-information in the data-tier.
     */
    public HousingLogic( HousingCommunicationInterface housingDAO,AgreementCommunicationInterface agreementDAO) {

        this.housingDAO = housingDAO;
        this.agreementDAO = agreementDAO;
    }

    /**
     *Implementation of a method that is meant to add new housing.
     * A new object is created and all the necessary parameters are added by calling the dto from the method argument.
     * The method uses try/catch block in order to catch any exceptions.
     * @param dto dto that contains all necessary new housing info to be added
     * @return HousingDTO
     */
    @Override
    public HousingDTO addHousing(HousingCreationDTO dto) {
        Housing housingToAdd = new Housing(dto.getCapacity(), new Address(dto.getCountry(), dto.getCity(), dto.getStreetName(), dto.getHouseNumber(), dto.getRoomNumber(), dto.getPostCode()),false);

        try {
           Housing addedHousing = housingDAO.addHousing(housingToAdd, dto.getHostEmail());
            return new HousingDTO(addedHousing,"");
        }
        catch (Exception e)
        {
            System.out.println("Failed connection with data-tier while executing 'addHousing'.");
            return new HousingDTO(housingToAdd,"Connection to the server was lost.");
        }
    }

    /**
     * Implementation of the method is meant to get all available housing.
     * A new Housing list is created that contains a list of housing that has availability
     * status set to true (the check if it is true is done by Jpa method).
     * @return HousingListDTO
     */
    @Override
    public HousingListDTO getAvailableHousing() {
        List<Housing> availableHousing = housingDAO.getAvailableHousing();
        return new HousingListDTO(availableHousing, "");
    }

    /**
     * Implementation of a method that is meant for removing housing from the database.
     * In the method a new object is created that contains a housing object that is referenced by method's argument.
     * IsEmpty check is done in order to make sure that the given id exists and that is followed by a check if
     * the housing is part of the agreement. Both check return HousingDTO with an error message.
     * If the object passes the checks, it's removed.
     * @param dto data transfer object that contains housing Id, host email and an error message.
     * @return HousingDTO
     */
    @Override
    public HousingDTO removeHousing(HousingIdDTO dto) {

        // housing check
        Optional<Housing> housing = housingDAO.getHousingById(dto.getHousingId());
        if (housing.isEmpty())
        {
            return new HousingDTO(null,"Housing with ID: "+dto.getHousingId()+ " doesn't exist." );
        }
        else if (!agreementDAO.getAllAgreementsByHousingId(housing.get().getHousingId()).isEmpty()) // todo is else if correct
        {
            return new HousingDTO(null, "This housing has active contract. First terminate contract.");
        }
        housingDAO.removeHousing(dto.getHousingId());
        return new HousingDTO(housing.get(),"");
    }

    /**
     * Implementation of the method returns all housings that belongs to a host.
     * In the method, a list of housings is created that contains all housings according to the given email in
     * the argument. isEmpty check is done in order either just display a message or return a list of housings.
     * @param email hosts email
     * @return HousingListDTO
     */
    @Override
    public HousingListDTO getHousingByHostId(String email) {
        List<Housing> housingList = housingDAO.getAllHousingByHostId(email);

        if (housingList.isEmpty()) {
            return new HousingListDTO(housingList, "No housing found for " + email);
        }
        return new HousingListDTO(housingList, "");
    }
}
