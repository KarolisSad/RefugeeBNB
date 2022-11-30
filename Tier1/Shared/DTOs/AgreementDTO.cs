using Shared.Domain;

namespace Shared.DTOs;

public class AgreementDTO
{
    public Agreement Agreement { get; }
    public string ErrorMessage{ get; }

    public AgreementDTO(Agreement agreement, string errorMessage)
    {
        Agreement = agreement;
        ErrorMessage = errorMessage;
    }
}