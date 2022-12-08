package via.sep3.group11.tier2.CommunicationInterfaces;


import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public interface RefugeeCommunicationInterface {
    Refugee createRefugee(Refugee refugee);
    Optional<Refugee> getRefugeeByEmail(String email);
    void deleteAccount(String email);
    Refugee updateInformation(Refugee refugee);
}
