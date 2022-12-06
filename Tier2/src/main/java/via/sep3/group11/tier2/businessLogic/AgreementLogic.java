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

@Service
public class AgreementLogic implements AgreementInterface {

    private HostCommunicationInterface hostDAO;
    private HousingCommunicationInterface housingDAO;
    private AgreementCommunicationInterface agreementDAO;
    private RefugeeCommunicationInterface refugeeDAO;

    public AgreementLogic(HostCommunicationInterface hostDAO, HousingCommunicationInterface housingDAO, AgreementCommunicationInterface agreementDAO, RefugeeCommunicationInterface refugeeDAO) {
        this.hostDAO = hostDAO;
        this.housingDAO = housingDAO;
        this.agreementDAO = agreementDAO;
        this.refugeeDAO = refugeeDAO;
    }

    @Override
    public AgreementDTO requestAgreement(RequestAgreementDTO dto) {
        Agreement dummyAgreement = dummyAgreement();

        // Host check
        Optional<Host> host = hostDAO.getHostByEmail(dto.getHostEmail());
        if (host.isEmpty())
        {
            return new AgreementDTO(dummyAgreement, "Owner of this housing deactivated his account and this housing is no longer available");
        }
        // Housing check
        Optional<Housing> housing = housingDAO.getHousingById(dto.getHousing().getHousingId());

        if (housing.isEmpty())
        {
            return new AgreementDTO(dummyAgreement, "This housing is no longer listed.");
        }
        if (!housing.get().isAvailable())
        {
            return new AgreementDTO(dummyAgreement, "This housing is already reserved.");
        }
        Optional<Refugee> refugee = refugeeDAO.getRefugeeByEmail(dto.getRefugeeEmail());

        // Create agreement
        Agreement agreementToCreate = new Agreement(host.get(),housing.get(),refugee.get());
        Agreement createdAgreement = agreementDAO.addAgreement(agreementToCreate);
        return new AgreementDTO(createdAgreement,"");
    }

    @Override
    public AgreementDTO respondToAgreement(RespondAgreementDTO dto) {
        Agreement dummyAgreement = dummyAgreement();

        // Agreement check
        Optional<Agreement> agreement = agreementDAO.getAgreementById(dto.getAgreementID());
        if (agreement.isEmpty())
        {
            System.out.println("agreement is empty");
            return new AgreementDTO(dummyAgreement,"This agreement no longer exists");
        }


        if (dto.isAccepted())
        {
            //Update housing
            Optional<Housing> updatedHousing = housingDAO.getHousingById(agreement.get().getHousing().getHousingId());
            updatedHousing.get().setAvailable(false);
            System.out.println("Should be false - before sending: " + updatedHousing.get().isAvailable());
            Housing test = housingDAO.updateHousing(updatedHousing.get());
            System.out.println("Should be false - after sending: " + test.isAvailable());

            // todo delete all requests for this housing

            // Update agreement
            agreement.get().setAccepted(true);
            agreementDAO.updateAgreement(agreement.get());
            return new AgreementDTO(agreement.get(),"");
        }
        else {
            // Delete agreement
            agreementDAO.deleteAgreement(agreement.get().getAgreementId());
            return new AgreementDTO(agreement.get(), "");
        }
    }

    @Override
    public AgreementListDTO getAllRequestsByHost(AgreementsByHostDTO dto) {
        List<Agreement> a = agreementDAO.getAgreementsByHostId(dto.getHostEmail());
        AgreementListDTO agreementListDTO = new AgreementListDTO(a, "");
        return agreementListDTO;
    }

    public Agreement dummyAgreement()
    {
        Host dummyHost = new Host("dummyHost","dummyHost@gmail.com","DummyHost", 'O',"DummyHost","DummyHost","DummyHost", new Date(01,01,2021));
        Housing dummyHousing = new Housing(1,new Address("DummyData","DummyData","DummyData","DummyData","DummyData","DummyData"),false);
        Refugee dummyRefugee = new Refugee("DummyRefugee@gmail.com","DummyRefugee",'O',"DummyRefugee","DummyRefugee","DummyRefugee","DummyRefugee",new Date(01,01,2021));
        return new Agreement(9999L,dummyHost,dummyHousing,dummyRefugee,false);
    }
}
