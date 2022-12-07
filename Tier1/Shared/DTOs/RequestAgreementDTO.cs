using Shared.Domain;

namespace Shared.DTOs;

public class RequestAgreementDTO
{
    public string RefugeeEmail { get; }
    public string HostEmail { get; }
    public Housing Housing { get; }
    public string ErrorMessage { get; }

    public RequestAgreementDTO(string refugeeEmail, string hostEmail, Housing housing, string errorMessage)
    {
        RefugeeEmail = refugeeEmail;
        HostEmail = hostEmail;
        Housing = housing;
        ErrorMessage = errorMessage;
    }
}