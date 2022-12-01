using Shared.Domain;

namespace Shared.DTOs;

public class RequestAgreementDTO
{
    public string RefugeeEmail;
    public string HostEmail;
    public Housing Housing;
    public string ErrorMessage;

    public RequestAgreementDTO(string refugeeEmail, string hostEmail, Housing housing, string errorMessage)
    {
        RefugeeEmail = refugeeEmail;
        HostEmail = hostEmail;
        Housing = housing;
        ErrorMessage = errorMessage;
    }
}