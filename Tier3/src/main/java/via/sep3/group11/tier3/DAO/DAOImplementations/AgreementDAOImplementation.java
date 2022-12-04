package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.DAO.DAOInterfaces.AgreementDaoInterface;
import via.sep3.group11.tier3.model.Agreement;
import via.sep3.group11.tier3.repository.AgreementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgreementDAOImplementation implements AgreementDaoInterface {

    private AgreementRepository agreementRepository;

    public AgreementDAOImplementation(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public Agreement addAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
    }


    @Override
    public Agreement updateAgreement(Agreement agreement) {
        Agreement toUpdate = agreementRepository.findById(agreement.getAgreementId()).get();
        toUpdate = agreement;

        return agreementRepository.save(toUpdate);
    }

    @Override
    public Optional<Agreement> getAgreementById(long agreementId) {
        return agreementRepository.findById(agreementId);
    }

    @Override
    public List<Agreement> getAgreementsByHostId(String hostId) {
        return agreementRepository.findAgreementsByHost_Email(hostId);
    }

    @Override
    public void deleteAgreement(long id) {
        agreementRepository.deleteById(id);
    }

    @Override
    public List<Agreement> getAllPendingAgreements(String hostEmail) {
        return agreementRepository.findAgreementsByAcceptedIsFalseAndHost_Email(hostEmail);
    }

    @Override
    public List<Agreement> getAllAgreementsByHousingId(long housingId) {
        return agreementRepository.findAgreementsByHousing_HousingId(housingId);
    }
}
