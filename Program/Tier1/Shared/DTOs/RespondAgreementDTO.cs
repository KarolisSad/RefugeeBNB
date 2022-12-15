namespace Shared.DTOs;

public class RespondAgreementDTO
{
    public long AgreementId { get; set; }
    public bool Accepted { get; set; }
    public string ErrorMessage { get; set; }

    public RespondAgreementDTO(long agreementId, bool accepted, string errorMessage)
    {
        AgreementId = agreementId;
        Accepted = accepted;
        ErrorMessage = errorMessage;
    }
}