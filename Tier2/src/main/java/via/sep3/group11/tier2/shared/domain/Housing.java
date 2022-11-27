package via.sep3.group11.tier2.shared.domain;


public class Housing {
    private long housingId;
    private int capacity;
    private Address address;

    private Host host;

    public Housing(int capacity, Address address, Host host) {
        setCapacity(capacity);
        setAddress(address);
        setHost(host);
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

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        if (host == null) {
            throw new NullPointerException("Host should not be null");
        }
        this.host = host;
    }
}
