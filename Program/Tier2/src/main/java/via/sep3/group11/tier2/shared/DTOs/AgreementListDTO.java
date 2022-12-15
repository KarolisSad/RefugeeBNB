package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Agreement;

import java.util.List;

public class AgreementListDTO
{
    private List<Agreement> agreementList;
    private String errorMessage;

    public AgreementListDTO(List<Agreement> agreementList, String errorMessage) {
        this.agreementList = agreementList;
        this.errorMessage = errorMessage;
    }

    public List<Agreement> getAgreementList() {
        return agreementList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
