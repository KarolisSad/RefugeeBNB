namespace Shared.Domain;


public class Address
{
    public long AddressId { get; set; }
    public string Country { set; get; }
    public string City { get; set; }
    public string StreetName { get; set; }
    public string HouseNumber { get; set; }
    public string RoomNumber { get; set; }
    public string PostCode { get; set; }

    public Address(string country, string city, string streetName, string houseNumber, string roomNumber, string postCode)
    {
        Country = country;
        City = city;
        StreetName = streetName;
        HouseNumber = houseNumber;
        RoomNumber = roomNumber;
        PostCode = postCode;
    }

    public Address(long addressId, string country, string city, string streetName, string houseNumber, string roomNumber, string postCode)
    {
        AddressId = addressId;
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