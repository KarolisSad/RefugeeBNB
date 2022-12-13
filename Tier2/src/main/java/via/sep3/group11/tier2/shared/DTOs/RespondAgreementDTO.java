package via.sep3.group11.tier2.shared.DTOs;

public class RespondAgreementDTO {
    private long agreementId;
    private boolean accepted;
    private String errorMessage;

    public RespondAgreementDTO(long agreementId, boolean accepted, String errorMessage) {
        this.agreementId = agreementId;
        this.accepted = accepted;
        this.errorMessage = errorMessage;
    }

    public long getAgreementId() {
        return agreementId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "RespondAgreementDTO{" +
                "agreementID=" + agreementId +
                ", accepted=" + accepted +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
