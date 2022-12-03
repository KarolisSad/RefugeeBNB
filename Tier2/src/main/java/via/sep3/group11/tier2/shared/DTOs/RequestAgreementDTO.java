package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Housing;

public class RequestAgreementDTO {
    private String refugeeEmail;
    private String hostEmail;
    private Housing housing;
    private String errorMessage;

    public RequestAgreementDTO(String refugeeEmail, String hostEmail, Housing housing, String errorMessage) {
        this.refugeeEmail = refugeeEmail;
        this.hostEmail = hostEmail;
        this.housing = housing;
        this.errorMessage = errorMessage;
    }

    public String getRefugeeEmail() {
        return refugeeEmail;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public Housing getHousing() {
        return housing;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
