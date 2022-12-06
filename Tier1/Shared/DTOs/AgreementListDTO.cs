using Shared.Domain;

namespace Shared.DTOs;

public class AgreementListDTO
{
    public List<Agreement> AgreementList { get; set; }
    public string ErrorMessage { get; set; }

    public AgreementListDTO(List<Agreement> agreementList, string errorMessage)
    {
        AgreementList = agreementList;
        ErrorMessage = errorMessage;
    }

    public AgreementListDTO()
    {
    }
}