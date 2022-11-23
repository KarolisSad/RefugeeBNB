namespace Shared.Domain;

public class Address
{
    private string Country { set; get; }
    private string City { get; set; }
    private string StreetName { get; set; }
    private string HouseNumber { get; set; }
    private string RoomNumber { get; set; }
    private string PostCode { get; set; }

    public Address(string country, string city, string streetName, string houseNumber, string roomNumber, string postCode)
    {
        Country = country;
        City = city;
        StreetName = streetName;
        HouseNumber = houseNumber;
        RoomNumber = roomNumber;
        PostCode = postCode;
    }

    public Address()
    {
    }
}