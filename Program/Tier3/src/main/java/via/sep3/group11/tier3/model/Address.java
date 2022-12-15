package via.sep3.group11.tier3.model;

import javax.persistence.*;

/**
 * A class responsible for creating an Address table.
 * Contains an entity annotation that persists to the database
 * and Data annotation in order to inject all the necessary constructors and methods
 *
 * @author Group 11
 * @version 28/11/22
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private long addressId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "postal_code")
    private String postalCode;


    public Address() {}

    public Address(long addressId, String country, String city, String streetName, String houseNumber, String roomNumber, String postalCode) {
        this.addressId = addressId;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
        this.postalCode = postalCode;
    }

    public Address(String country, String city, String streetName, String houseNumber, String roomNumber, String postalCode) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
        this.postalCode = postalCode;
    }

    public long getAddressId() {
        return addressId;
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

    public String getPostalCode() {
        return postalCode;
    }
}