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
@Table(name = "housing")
public class Housing {

    @Id
    @SequenceGenerator(name = "housing_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "housing_sequence")
    private long housingId;

    @Column(name = "capacity")
    private int capacity;


    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    public Housing() {}

    public Housing(int capacity, Address address) {
        this.capacity = capacity;
        this.address = address;
    }

    public long getHousingId() {
        return housingId;
    }

    public int getCapacity() {
        return capacity;
    }

    public Address getAddress() {
        return address;
    }


}
