package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Refugee;

public class AgreementsByHostDTO {
    private String hostEmail;
    private String errorMessage;

    public AgreementsByHostDTO(String hostEmail, String errorMessage) {
        this.hostEmail = hostEmail;
        this.errorMessage = errorMessage;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
