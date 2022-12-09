package via.sep3.group11.tier2.CommunicationInterfaces;
import via.sep3.group11.tier2.shared.DTOs.HostDTO;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;
import java.util.Optional;

public interface HostCommunicationInterface {
    Host createHost(Host host);
    Optional<Host> getHostByEmail(String email);
    Optional<Host> getHostByHousingId (long housingId);
    void deleteAccount(String email);
    Host updateInformation(Host host);
}
