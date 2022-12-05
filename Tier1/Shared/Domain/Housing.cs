namespace Shared.Domain;

public class Housing
{
    public long HousingId { get; set; }
    public int Capacity { get; set; }
    public Address Address { get; set; }

    public bool Available { get; set; }

    public Housing(int capacity, Address address, bool available)
    {
        Capacity = capacity;
        Address = address;
        Available = available;
    }

    public Housing(long housingId, int capacity, Address address, bool available)
    {
        HousingId = housingId;
        Capacity = capacity;
        Address = address;
        Available = available;
    }

    public Housing()
    {
    }
}