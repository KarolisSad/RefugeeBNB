package via.sep3.group11.tier2.shared.DTOs;

public class RespondAgreementDTO {
    private long agreementID;
    private boolean accepted;
    private String errorMessage;

    public RespondAgreementDTO(long agreementID, boolean accepted, String errorMessage) {
        this.agreementID = agreementID;
        this.accepted = accepted;
        this.errorMessage = errorMessage;
    }

    public long getAgreementID() {
        return agreementID;
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
                "agreementID=" + agreementID +
                ", accepted=" + accepted +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
