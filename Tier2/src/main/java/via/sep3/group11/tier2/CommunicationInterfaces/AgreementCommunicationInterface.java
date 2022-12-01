package via.sep3.group11.tier2.CommunicationInterfaces;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public interface AgreementCommunicationInterface {
    Agreement addAgreement(Agreement agreement) throws ValidationException;
    Agreement updateAgreement(Agreement agreement);
    Optional<Agreement> getAgreementById(long agreementId);
    List<Agreement> getAgreementByHostId(String hostId);
    void deleteAgreement(long agreementId);
    List<Agreement> getAllPendingAgreements(String hostEmail);
    List<Agreement> getAllAgreementsByHousingId(Long housingId);
}

