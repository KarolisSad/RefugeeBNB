package via.sep3.group11.tier2.shared.domain;


public class Housing {
    private long housingId;
    private int capacity;
    private Address address;

    public Housing(int capacity, Address address) {
        setCapacity(capacity);
        setAddress(address);
    }

    public long getHousingId() {
        return housingId;
    }

    public void setHousingId(long housingId) {
        this.housingId = housingId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity should not be less than one!");
        }
        this.capacity = capacity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new NullPointerException("Address should not be null!");
        }
        this.address = address;
    }
}
