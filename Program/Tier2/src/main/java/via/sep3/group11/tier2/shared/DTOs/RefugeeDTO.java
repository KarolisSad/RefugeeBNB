package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Refugee;

public class RefugeeDTO {
    private Refugee refugee;
    private String errorMessage;

    public RefugeeDTO(Refugee refugee, String errorMessage) {
        this.refugee = refugee;
        this.errorMessage = errorMessage;
    }

    public Refugee getRefugee() {
        return refugee;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "RefugeeDTO{" +
                "refugee=" + refugee +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
