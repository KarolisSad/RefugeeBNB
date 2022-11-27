package via.sep3.group11.tier2.shared.domain;


import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import static via.sep3.group11.tier2.shared.domain.ValidationHelper.SimpleValidateString;


public class Address {

    private long addressId;
    private String country;
    private String city;
    private String streetName;
    private String houseNumber;
    private String roomNumber;
    private String postCode;

    public Address(String country, String city, String streetName, String houseNumber, String roomNumber, String postCode) throws ValidationException {
        setCountry(country);
        setCity(city);
        setStreetName(streetName);
        setHouseNumber(houseNumber);
        setRoomNumber(roomNumber);
        setPostCode(postCode);
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws ValidationException {
        SimpleValidateString(country, "Country");
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ValidationException {
        SimpleValidateString(city, "City");
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) throws ValidationException {
        SimpleValidateString(streetName, "Street name");
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) throws ValidationException {
        SimpleValidateString(houseNumber, "House Number");
        this.houseNumber = houseNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        try {
            SimpleValidateString(roomNumber, "Room Number");
            this.roomNumber = roomNumber;
        } catch (ValidationException ve) {
            this.roomNumber = "";
        }
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) throws ValidationException {
        SimpleValidateString(postCode, "Postcode");
        this.postCode = postCode;
    }
}
