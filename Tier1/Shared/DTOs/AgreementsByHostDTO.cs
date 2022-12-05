namespace Shared.DTOs;

public class AgreementsByHostDTO
{
    public string HostEmail;
    public string ErrorMessage;

    public AgreementsByHostDTO(string hostEmail, string errorMessage)
    {
        HostEmail = hostEmail;
        ErrorMessage = errorMessage;
    }
}