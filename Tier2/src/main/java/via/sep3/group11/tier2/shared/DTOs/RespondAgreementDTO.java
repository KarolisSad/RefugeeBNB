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
}
