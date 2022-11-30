package via.sep3.group11.tier2.CommunicationInterfaces;


import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

public interface HousingCommunicationInterface {
    Housing addHousing(Housing housing, String email) throws ValidationException;
}
