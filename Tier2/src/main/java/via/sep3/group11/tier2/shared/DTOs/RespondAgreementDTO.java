package via.sep3.group11.tier2.shared.DTOs;

public class RespondAgreementDTO {
    private Long agreementID;
    private boolean accepted;
    private String errorMessage;

    public RespondAgreementDTO(Long agreementID, boolean accepted, String errorMessage) {
        this.agreementID = agreementID;
        this.accepted = accepted;
        this.errorMessage = errorMessage;
    }

    public Long getAgreementID() {
        return agreementID;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
