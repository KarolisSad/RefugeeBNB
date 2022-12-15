package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Housing;

import java.util.List;

public class HousingListDTO {
    private List<Housing> housingList;
    private String errorMessage;

    public HousingListDTO(List<Housing> housingList, String errorMessage) {
        this.housingList = housingList;
        this.errorMessage = errorMessage;
    }

    public List<Housing> getHousingList() {
        return housingList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
