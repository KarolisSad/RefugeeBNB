package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Housing;

public class HousingDTO {
    private Housing housing;
    private String errorMessage;

    public HousingDTO(Housing housing, String errorMessage) {
        this.housing = housing;
        this.errorMessage = errorMessage;
    }

    public Housing getHousing() {
        return housing;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
