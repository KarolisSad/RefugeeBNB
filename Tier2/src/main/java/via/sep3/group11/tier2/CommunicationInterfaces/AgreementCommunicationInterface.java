package via.sep3.group11.tier2.CommunicationInterfaces;

import via.sep3.group11.tier2.shared.DTOs.HostDTO;
import via.sep3.group11.tier2.shared.domain.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementCommunicationInterface {
    Agreement addAgreement(Agreement agreement);
    Agreement updateAgreement(Agreement agreement);
    Optional<Agreement> getAgreementById(long agreementId);
    List<Agreement> getAgreementsByHostId(String hostId);
    void deleteAgreement(long agreementId);
    List<Agreement> getAllAgreementsByHousingId(long housingId);
    Optional<Agreement> getAgreementByRefugeeEmail (String email);
}

