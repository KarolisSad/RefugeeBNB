package via.sep3.group11.tier3.services.serviceImp;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.repository.AddressRepository;
import via.sep3.group11.tier3.services.servicesInterfaces.AddressDaoInterface;

@Service
public class AddressService implements AddressDaoInterface {

    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address addAddress(Address address, long housingId) {
        return repository.save(address);
    }
}
