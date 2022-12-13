package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.DAO.DAOInterfaces.AgreementDaoInterface;
import via.sep3.group11.tier3.model.Agreement;
import via.sep3.group11.tier3.model.Housing;
import via.sep3.group11.tier3.repository.AgreementRepository;
import via.sep3.group11.tier3.repository.HousingRepository;

import java.util.List;
import java.util.Optional;

import static via.sep3.group11.tier3.model.Date.convertLocalDateToDateObject;

/**
 * Class implementing the Agreement DAO-interface.
 * This class uses an interface extending JpaRepository<Agreement, Long> to access a PostgreSQL database.
 * @author Group 11
 * @version 5/12-2022
 */
@Service
public class AgreementDAOImplementation implements AgreementDaoInterface {

    private AgreementRepository agreementRepository;
    private HousingRepository housingRepo;

    public AgreementDAOImplementation(AgreementRepository agreementRepository, HousingRepository housingRepo) {
        this.agreementRepository = agreementRepository;
        this.housingRepo = housingRepo;
    }

    @Override
    public Agreement addAgreement(Agreement agreement) {

        Optional<Housing> housing = housingRepo.findById(agreement.getHousing().getHousingId());
        Agreement newAgreement = new Agreement(convertLocalDateToDateObject(agreement.getDate()),
                agreement.getRefugee(), housing.get(), agreement.getHost());

        return agreementRepository.save(newAgreement);
    }

    /**
     * Method used for updating an existing agreement entity in the database.
     * This is done by taking an updated version of the agreement entity as an argument (the actual updating is done in the logic tier).
     * The repository then checks if the agreement actually exists in the database, and then overwrites it with the updated version.
     * @param agreement The updated agreement object used to overwrite the already existing entity in the database.
     * @return The updated agereement entity from the database after the update is done, or null if no entity with a matching id is found.
     */
    @Override
    public Agreement updateAgreement(Agreement agreement) {
        Agreement updated = agreementRepository.save(agreement);
        if (agreementRepository.findById(agreement.getAgreementId()).isPresent()) {
            deletePendingAgreements(agreement.getHost().getEmail());
            return updated;
        }
        return null;
    }

    public void deletePendingAgreements(String hostEmail) {
        List<Agreement> agreements = agreementRepository.findAgreementsByAcceptedIsFalseAndHost_Email(hostEmail);
        for(int i = 0; i < agreements.size(); i++) {
            agreementRepository.deleteById(agreements.get(i).getAgreementId());
        }
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
    public List<Agreement> getAllAgreementsByHousingId(long housingId) {
        return agreementRepository.findAgreementsByHousing_HousingId(housingId);
    }

    @Override
    public Optional<Agreement> getAgreementByRefugeeEmail(String refugeeEmail) {
        return agreementRepository.findAgreementByAcceptedIsTrueAndRefugee_Email(refugeeEmail);
    }
}
