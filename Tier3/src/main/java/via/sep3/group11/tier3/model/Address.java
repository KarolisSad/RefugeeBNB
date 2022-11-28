package via.sep3.group11.tier3.model;

import lombok.Data;
import javax.persistence.*;

/**
 * A class responsible for creating an Address table.
 * Contains an entity annotation that persists to the database
 * and Data annotation in order to inject all the necessary constructors and methods
 *
 * @author Group 11
 * @version 28/11/22
 */
@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private long addressId;

    @OneToOne
    @JoinColumn (name = "housingId")
    private Housing housing;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street_name")
    private String strName;

    @Column(name = "house_number")
    private int houseNr;

    @Column(name = "room_number")
    private int roomNr;

    @Column(name = "postal_code")
    private String postalCode;
}