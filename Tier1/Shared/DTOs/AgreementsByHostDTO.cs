namespace Shared.DTOs;

public class AgreementsByHostDTO
{
    public string HostEmail { get; }
    public string ErrorMessage { get; }

    public AgreementsByHostDTO(string hostEmail, string errorMessage)
    {
        HostEmail = hostEmail;
        ErrorMessage = errorMessage;
    }
}