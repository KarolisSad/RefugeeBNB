package via.sep3.group11.tier3.DAO.DAOInterfaces;

import via.sep3.group11.tier3.model.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementDaoInterface {
    Agreement addAgreement(Agreement agreement);
    Agreement updateAgreement(Agreement agreement);
    Optional<Agreement> getAgreementById(long agreementId);
    List<Agreement> getAgreementsByHostId(String hostId);
    void deleteAgreement(long id);
    List<Agreement> getAllAgreementsByHousingId(long housingId);
    Optional<Agreement> getAgreementByRefugeeEmail (String email);
}
