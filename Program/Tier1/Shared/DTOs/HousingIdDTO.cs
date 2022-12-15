namespace Shared.DTOs;

public class HousingIdDTO
{
    public long HousingId { get; }
    public string HostEmail { get; }
    public string ErrorMessage { get; }

    public HousingIdDTO(long housingId, string hostEmail, string errorMessage)
    {
        HousingId = housingId;
        HostEmail = hostEmail;
        ErrorMessage = errorMessage;
    }
}