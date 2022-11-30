package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.AgreementInterface;
import via.sep3.group11.tier2.shared.DTOs.AgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.AgreementsByHostDTO;
import via.sep3.group11.tier2.shared.DTOs.RequestAgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.RespondAgreementDTO;
import via.sep3.group11.tier2.shared.domain.*;
import java.util.List;
import java.util.Optional;

@Service
public class AgreementLogic implements AgreementInterface {

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementDTO;
    private RefugeeCommunicationInterface refugeeDTO;

    public AgreementLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO, AgreementCommunicationInterface agreementDTO, RefugeeCommunicationInterface refugeeDTO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
        this.agreementDTO = agreementDTO;
        this.refugeeDTO = refugeeDTO;
    }

    @Override
    public AgreementDTO requestAgreement(RequestAgreementDTO dto) {
        // Creating dummy agreement, because now it's required to return some kind of Agreement TODO change DTOs
        Agreement dummyAgreement = dummyAgreement();

        Optional<Host> host = hostDAO.getHostByEmail(dto.getHostEmail());
        if (host.isEmpty())
        {
            return new AgreementDTO(dummyAgreement, "Owner of this housing deactivated his account and this housing is no longer available");
        }

        // Checking if housing is still listed & available
        Optional<Housing> housing = housingDAO.getHousingById(dto.getHousing().getHousingId());
        if (housing.isEmpty())
        {
            return new AgreementDTO(dummyAgreement, "This housing is no longer listed.");
        }
        if (!housing.get().isAvailable())
        {
            return new AgreementDTO(dummyAgreement, "This housing is already reserved.");
        }
        Optional<Refugee> refugee = refugeeDTO.getRefugeeByEmail(dto.getRefugeeEmail());

        Agreement agreementToCreate = new Agreement(host.get(),housing.get(),refugee.get());
        Agreement createdAgreement = agreementDTO.addAgreement(agreementToCreate);
        return new AgreementDTO(createdAgreement,"");
    }

    @Override
    public AgreementDTO respondToAgreement(RespondAgreementDTO dto) {
        Agreement dummyAgreement = dummyAgreement();  // Creating dummy agreement, because now it's required to return some kind of Agreement TODO change DTOs

        // Getting agreement & setting availability
        Optional<Agreement> agreement = agreementDTO.getAgreementById(dto.getAgreementID());
        if (agreement.isEmpty())
        {
            return new AgreementDTO(dummyAgreement,"This agreement no longer exists");
        }

        if (dto.isAccepted())
        {
            //Update housing to not available
            Optional<Housing> updatedHousing = housingDAO.getHousingById(agreement.get().getHousing().getHousingId());
            updatedHousing.get().setAvailable(false);
            housingDAO.updateHousing(updatedHousing.get());

            //Todo Delete all requests for this housing
            // Deleting all requests for this housing

            // Update agreement & return
            agreement.get().setAccepted(true);
            agreementDTO.updateAgreement(agreement.get());
            return new AgreementDTO(agreement.get(),"");
        }
        else {
            // Delete agreement
            agreementDTO.deleteAgreement(agreement.get().getAgreementId());
            return new AgreementDTO(agreement.get(), "");
        }
    }

    @Override
    public List<Agreement> getAllRequestsByHost(AgreementsByHostDTO dto) {
        return agreementDTO.getAllPendingAgreements(dto.getHostEmail());
    }

    //TODO Delete this, after fixing DTOs
    public Agreement dummyAgreement()
    {
        Host dummyHost = new Host("dummyHost","dummyHost@gmail.com","DummyHost", 'O',"DummyHost","DummyHost","DummyHost", new Date(01,01,2021));
        Housing dummyHousing = new Housing(1,new Address("DummyData","DummyData","DummyData","DummyData","DummyData","DummyData"),false);
        Refugee dummyRefugee = new Refugee("DummyRefugee@gmail.com","DummyRefugee",'O',"DummyRefugee","DummyRefugee","DummyRefugee","DummyRefugee",new Date(01,01,2021));
        return new Agreement(9999L,dummyHost,dummyHousing,dummyRefugee,false);
    }
}
