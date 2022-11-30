namespace Shared.DTOs;

public class HousingCreationDTO
{
    public string Country { get; }
    public string City{ get; }
    public string StreetName{ get; }
    public string HouseNumber{ get; }
    public string RoomNumber{ get; }
    public string PostCode{ get; }
    public int Capacity{ get; }
    public string HostEmail{ get; }

    public string ErrorMessage { get; }

    public HousingCreationDTO(string country, string city, string streetName, string houseNumber, string roomNumber, string postCode, int capacity, string hostEmail, string errorMessage)
    {
        Country = country;
        City = city;
        StreetName = streetName;
        HouseNumber = houseNumber;
        RoomNumber = roomNumber;
        PostCode = postCode;
        Capacity = capacity;
        HostEmail = hostEmail;
        ErrorMessage = errorMessage;
    }
    
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
        ErrorMessage = "";
    }
}