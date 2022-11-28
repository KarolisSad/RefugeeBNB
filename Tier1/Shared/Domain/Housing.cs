namespace Shared.Domain;

public class Housing
{
    public int Capacity { get; set; }
    public Address Address { get; set; }

    public Housing(int capacity, Address address)
    {
        Capacity = capacity;
        Address = address;
    }

    public Housing()
    {
    }
}