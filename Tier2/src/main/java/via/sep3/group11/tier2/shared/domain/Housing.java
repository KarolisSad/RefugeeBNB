package via.sep3.group11.tier2.shared.domain;

/**
 * Class representing a Housing-object.
 * @version 27/11-2022
 * @author Group 11
 */
public class Housing {
    private long housingId;
    private int capacity;
    private Address address;
    private boolean available;



    public Housing(int capacity, Address address, boolean available) {
        this.capacity = capacity;
        this.address = address;
        this.available = available;
    }

    public Housing(long housingId, int capacity, Address address, boolean available) {
        this.housingId = housingId;
        this.capacity = capacity;
        this.address = address;
        this.available = available;
    }

    public Housing() {
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

    public void setHousingId(long housingId) {
        this.housingId = housingId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "housingId=" + housingId +
                ", capacity=" + capacity +
                ", address=" + address +
                ", available=" + available +
                '}';
    }

    //                          GRAVE OF GREAT CODE :(


    //
//    /**
//     * 2-argument constructor used to create an instance of the object.
//     * All arguments are initialized by calling their corresponding set-method.
//     * The housingId attribute is not assigned here, as it is generated and assigned by the database.
//     * @param capacity: The capacity of the Housing (the number of people it fits)
//     * @param address: Tha address of the housing.
//     * @throws IllegalArgumentException if the setCapacity method throws an exception.
//     * @throws NullPointerException if the setAddress method throws an exception.
//     */
//    public Housing(int capacity, Address address) throws IllegalArgumentException, NullPointerException{
//        setCapacity(capacity);
//        setAddress(address);
//    }
//
//    /**
//     * Getter-method for the housing id.
//     * @return the id of the housing object.
//     */
//    public long getHousingId() {
//        return housingId;
//    }
//
//    //Todo Would this ever be needed??
//    public void setHousingId(long housingId) {
//        this.housingId = housingId;
//    }
//
//    /**
//     * Getter-method for the capacity.
//     * @return the capacity of the housing object.
//     */
//    public int getCapacity() {
//        return capacity;
//    }
//
//    /**
//     * Setter-method for the capacity of the housing object.
//     * @param capacity: The number of people that the object fits.
//     * @throws IllegalArgumentException if the parameter is less than 1.
//     */
//    public void setCapacity(int capacity) {
//        if (capacity < 1) {
//            throw new IllegalArgumentException("Capacity should not be less than one!");
//        }
//        this.capacity = capacity;
//    }
//
//    /**
//     * Getter-method for the address.
//     * @return the address of the housing object.
//     */
//    public Address getAddress() {
//        return address;
//    }
//
//    /**
//     * Setter-method for setting the address of the object.
//     * @param address the address to be assigned to the object.
//     * @throws NullPointerException if the parameter is null.
//     */
//    public void setAddress(Address address) {
//        if (address == null) {
//            throw new NullPointerException("Address should not be null!");
//        }
//        this.address = address;
//    }
}
