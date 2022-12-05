package via.sep3.group11.tier3.DAO.DAOImplementations;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.DAO.DAOInterfaces.AgreementDaoInterface;
import via.sep3.group11.tier3.model.Agreement;
import via.sep3.group11.tier3.repository.AgreementRepository;

import java.util.List;
import java.util.Optional;

/**
 * Class implementing the Agreement DAO-interface.
 * This class uses an interface extending JpaRepository<Agreement, Long> to access a PostgreSQL database.
 * @author Group 11
 * @version 5/12-2022
 */
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


    /**
     * Method used for updating an existing agreement entity in the database.
     * This is done by taking an updated version of the agremeent entity as an argument (the actual updating is done in the logic tier).
     * The repository then checks if the agreement actually exists in the database, and then overwrites it with the updated version.
     * @param agreement The updated agreement object used to overwrite the already existing entity in the database.
     * @return The updated agerement entity from the database after the update is done, or null if no entity with a matching id is found.
     */
    @Override
    public Agreement updateAgreement(Agreement agreement) {
        if (agreementRepository.findById(agreement.getAgreementId()).isPresent()) {

            return agreementRepository.save(agreement);
        }

        return null;
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
