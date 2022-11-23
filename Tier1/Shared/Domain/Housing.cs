namespace Shared.Domain;

public class Housing
{
    private int Capacity { get; set; }
    private Address Address { get; set; }

    public Housing(int capacity, Address address)
    {
        Capacity = capacity;
        Address = address;
    }

    public Housing()
    {
    }
}