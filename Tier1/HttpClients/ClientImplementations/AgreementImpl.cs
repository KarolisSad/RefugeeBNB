using HttpClients.ClientInterfaces;
using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientImplementations;

public class AgreementImpl:AgreementInterface
{
    public Task<RequestAgreementDTO> RequestAgreement(RequestAgreementDTO dto)
    {
        throw new NotImplementedException();
    }

    public Task<RespondAgreementDTO> RespondToAgreement(RespondAgreementDTO dto)
    {
        throw new NotImplementedException();
    }

    public Task<List<Agreement>> GetAllRequestsByHostDTO(AgreementsByHostDTO dto)
    {
        throw new NotImplementedException();
    }
}