package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Agreement;

public class AgreementDTO {
    private Agreement agreement;
    private String errorMessage;

    public AgreementDTO(Agreement agreement, String errorMessage) {
        this.agreement = agreement;
        this.errorMessage = errorMessage;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


}
