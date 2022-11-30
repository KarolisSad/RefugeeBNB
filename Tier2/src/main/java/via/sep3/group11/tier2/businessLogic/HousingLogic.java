package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.HousingInterface;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingIdDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingListDTO;
import via.sep3.group11.tier2.shared.domain.Address;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Housing;

import java.util.List;
import java.util.Optional;

@Service
public class HousingLogic implements HousingInterface {

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;

    public HousingLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
    }
    @Override
    public HousingDTO addHousing(HousingCreationDTO dto) {
        // Create housing
        Housing housingToAdd = new Housing(dto.getCapacity(),
                new Address(dto.getCountry(), dto.getCity(), dto.getStreetName(),
                        dto.getHouseNumber(), dto.getRoomNumber(), dto.getPostCode()),false);

        // Get Housing from database
        Housing addedHousing = housingDAO.addHousing(housingToAdd, dto.getHostEmail());
        // TODO catch exception, if DB wasn't contacted
        HousingDTO housingDTO = new HousingDTO(addedHousing,"");


        return null;
    }

    @Override
    public HousingListDTO getAvailableHousing() {
        List<Housing> availableHousing = housingDAO.getAvailableHousing();
        return new HousingListDTO(availableHousing, "");
    }

    @Override
    public HousingDTO removeHousing(HousingIdDTO dto) {
        Housing dummyHousing = new Housing(1,new Address("DummyData","DummyData","DummyData","DummyData","DummyData","DummyData"),false);

        Optional<Housing> housing = housingDAO.getHousingById(dto.getHousingId());
        if (housing.isEmpty())
        {
            return new HousingDTO(dummyHousing,"Housing with ID: "+dto.getHousingId()+ " doesn't exist." );
        }
        housingDAO.removeHousing(dto.getHousingId());
        return new HousingDTO(housing.get(),"");
    }

}
