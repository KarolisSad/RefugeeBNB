namespace Shared.DTOs;

public class RespondAgreementDTO
{
    public long AgreementId;
    public bool Accepted;
    public string ErrorMessage;

    public RespondAgreementDTO(long agreementId, bool accepted, string errorMessage)
    {
        AgreementId = agreementId;
        Accepted = accepted;
        ErrorMessage = errorMessage;
    }
}