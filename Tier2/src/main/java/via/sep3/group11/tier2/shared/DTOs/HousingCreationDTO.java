package via.sep3.group11.tier2.shared.DTOs;

/**
 * Domain Transfer Object used to add a new Housing object in the system.
 * @version 27/11-2022
 * @author Group 11
 */
public class HousingCreationDTO {

    private String country;
    private String city;
    private String streetName;
    private String houseNumber;
    private String roomNumber;
    private String postCode;
    private int capacity;
    private String hostEmail;

    private String errorMessage;

    /**
     * All-argument constructor used to create an instance of the DTO with all variables set.
     * @param country: The country in which the housing exists.
     * @param city: The city in which the housing exists.
     * @param streetName: The name of the street of the housing.
     * @param houseNumber: The house number of the housing.
     * @param roomNumber: The room number of the housing.
     * @param postCode: The post code for the city of the housing.
     * @param capacity: The number of people that the housing can fit.
     * @param hostEmail: The email of the owner of the housing.
     */
    public HousingCreationDTO(String country, String city, String streetName,
                              String houseNumber, String roomNumber, String postCode,
                              int capacity, String hostEmail, String errorMessage) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
        this.postCode = postCode;
        this.capacity = capacity;
        this.hostEmail = hostEmail;
        this.errorMessage = errorMessage;
    }

    /**
     * Simple getter method for country.
     * @return the country of the DTO.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Simple getter method for city.
     * @return the city of the DTO.
     */
    public String getCity() {
        return city;
    }

    /**
     * Simple getter method for street name.
     * @return the street name of the DTO.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Simple getter method for house number.
     * @return the house number of the DTO.
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Simple getter method for room number.
     * @return the room number of the DTO.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Simple getter method for post code.
     * @return the post code of the DTO.
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Simple getter method for capacity.
     * @return the capacity of the DTO.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Simple getter method for email of the host.
     * @return the email of the DTO.
     */
    public String getHostEmail() {
        return hostEmail;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
