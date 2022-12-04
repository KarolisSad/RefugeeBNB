package via.sep3.group11.tier2.CommunicationInterfaces;

import via.sep3.group11.tier2.shared.domain.Agreement;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.List;
import java.util.Optional;

public interface AgreementCommunicationInterface {

    Agreement addAgreement(Agreement agreement) throws ValidationException;
    Agreement updateAgreement(Agreement agreement) throws ValidationException;
    Optional<Agreement> getAgreementById(long agreementId) throws ValidationException;
    List<Agreement> getAgreementByHostId(String hostId) throws ValidationException;
    void deleteAgreement(long agreementId);
    List<Agreement> getAllPendingAgreements(String hostEmail);
    List<Agreement> getAllAgreementsByHousingId(Long housingId) throws ValidationException;
}

