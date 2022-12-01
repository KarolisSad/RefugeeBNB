namespace Shared.DTOs;

public class HousingIdDTO
{
    public long HousingId;
    public string HostEmail;
    public string ErrorMessage;

    public HousingIdDTO(long housingId, string hostEmail, string errorMessage)
    {
        HousingId = housingId;
        HostEmail = hostEmail;
        ErrorMessage = errorMessage;
    }
}