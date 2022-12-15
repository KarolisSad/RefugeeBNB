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
    @SequenceGenerator(name = "housing_sequence", sequenceName = "housing_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "housing_sequence")
    private long housingId;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "available")
    private boolean available;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;


    @ManyToOne
    @JoinTable(name = "housing_host")
    public Host host;

    public Housing() {}

    //todo maybe delete??
    /*
    public Housing(int capacity, Address address) {
        this.capacity = capacity;
        this.address = address;
        available = true;
    }

     */

    public Housing(long housingId, int capacity, Address address) {
        this.housingId = housingId;
        this.capacity = capacity;
        this.address = address;
        available = true;
    }

    public Housing(long housingId, int capacity, boolean available, Address address) {
        this.housingId = housingId;
        this.capacity = capacity;
        this.available = available;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "housingId=" + housingId +
                ", capacity=" + capacity +
                ", available=" + available +
                ", address=" + address +
                ", host=" + host +
                '}';
    }
}
