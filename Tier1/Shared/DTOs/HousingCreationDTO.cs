namespace Shared.DTOs;

public class HousingCreationDTO
{
    private string Country { get; }
    private string City{ get; }
    private string StreetName{ get; }
    private string HouseNumber{ get; }
    private string RoomNumber{ get; }
    private string PostCode{ get; }
    private int Capacity{ get; }
    private string HostEmail{ get; }


    public HousingCreationDTO(string country, string city, string streetName, string houseNumber, string roomNumber, string postCode, int capacity, string hostEmail)
    {
        Country = country;
        City = city;
        StreetName = streetName;
        HouseNumber = houseNumber;
        RoomNumber = roomNumber;
        PostCode = postCode;
        Capacity = capacity;
        HostEmail = hostEmail;
    }
}