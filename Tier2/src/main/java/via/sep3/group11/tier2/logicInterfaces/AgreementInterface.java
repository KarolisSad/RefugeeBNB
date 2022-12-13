package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Agreement;

import java.util.List;

public interface AgreementInterface {
    AgreementDTO requestAgreement(RequestAgreementDTO dto);
    AgreementDTO respondToAgreement(RespondAgreementDTO dto);
    AgreementListDTO getAllRequestsByHost(AgreementsByHostDTO dto);
    AgreementDTO getAgreementByRefugeeEmail(String refugeeEmail);
}
