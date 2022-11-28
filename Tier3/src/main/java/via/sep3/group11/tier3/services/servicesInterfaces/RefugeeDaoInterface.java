package via.sep3.group11.tier3.services.servicesInterfaces;

import via.sep3.group11.tier3.model.Refugee;

import java.util.Optional;

public interface RefugeeDaoInterface {

    Refugee createRefugee (Refugee refugee);
    Optional<Refugee> getRefugeeByEmail (String email);
}
