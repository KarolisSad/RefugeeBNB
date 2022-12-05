package via.sep3.group11.tier2.logicInterfaces;

import via.sep3.group11.tier2.shared.DTOs.AgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.AgreementsByHostDTO;
import via.sep3.group11.tier2.shared.DTOs.RequestAgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.RespondAgreementDTO;
import via.sep3.group11.tier2.shared.domain.Agreement;

import java.util.List;

public interface AgreementInterface {
    AgreementDTO requestAgreement(RequestAgreementDTO dto);
    AgreementDTO respondToAgreement(RespondAgreementDTO dto);
    List<Agreement> getAllRequestsByHost(AgreementsByHostDTO dto);
}
