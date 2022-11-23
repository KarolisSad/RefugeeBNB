package via.sep3.group11.tier2.shared.domain;

import lombok.Data;

@Data
public class Address {

    private long addressId;
    private String country;
    private String city;
    private String streetName;
    private String houseNumber;
    private String roomNumber;
    private String postCode;


    // todo add validation here
}
