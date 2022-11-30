package via.sep3.group11.tier2.shared.DTOs;

public class HousingIdDTO {
    private Long housingId;
    private String hostEmail;
    private String errorMessage;

    public HousingIdDTO(Long housingId, String hostEmail, String errorMessage) {
        this.housingId = housingId;
        this.hostEmail = hostEmail;
        this.errorMessage = errorMessage;
    }

    public Long getHousingId() {
        return housingId;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
