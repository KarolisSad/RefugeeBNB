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

@Service
public class HousingLogic implements HousingInterface {

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementDAO;

    public HousingLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO,AgreementCommunicationInterface agreementDAO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
        this.agreementDAO = agreementDAO;
    }
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

    @Override
    public HousingListDTO getAvailableHousing() {
        List<Housing> availableHousing = housingDAO.getAvailableHousing();
        return new HousingListDTO(availableHousing, "");
    }

    @Override
    public HousingDTO removeHousing(HousingIdDTO dto) {
        Housing dummyHousing = new Housing(1,new Address("DummyData","DummyData","DummyData","DummyData","DummyData","DummyData"),false);

        // housing check
        Optional<Housing> housing = housingDAO.getHousingById(dto.getHousingId());
        if (housing.isEmpty())
        {
            return new HousingDTO(dummyHousing,"Housing with ID: "+dto.getHousingId()+ " doesn't exist." );
        }
        if (!agreementDAO.getAllAgreementsByHousingId(housing.get().getHousingId()).isEmpty())
        {
            return new HousingDTO(dummyHousing, "This housing has active contract. First terminate contract.");
        }
        housingDAO.removeHousing(dto.getHousingId());
        return new HousingDTO(housing.get(),"");
    }

    @Override
    public HousingListDTO getHousingByHostId(String email) {
        return null;
    }


}
