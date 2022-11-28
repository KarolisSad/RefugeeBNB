package via.sep3.group11.tier3.services.servicesInterfaces;

import via.sep3.group11.tier3.model.Address;

public interface AddressDaoInterface {
    Address addAddress(Address address, long housingId);
}
