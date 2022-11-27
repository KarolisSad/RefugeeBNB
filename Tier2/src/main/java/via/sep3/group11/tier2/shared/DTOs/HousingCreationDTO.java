package via.sep3.group11.tier2.shared.DTOs;

public class HousingCreationDTO {

    private String country;
    private String city;
    private String streetName;
    private String houseNumber;
    private String roomNumber;
    private String postCode;
    private int capacity;
    private String hostEmail;

    public HousingCreationDTO(String country, String city, String streetName,
                              String houseNumber, String roomNumber, String postCode,
                              int capacity, String hostEmail) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
        this.postCode = postCode;
        this.capacity = capacity;
        this.hostEmail = hostEmail;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getHostEmail() {
        return hostEmail;
    }
}
