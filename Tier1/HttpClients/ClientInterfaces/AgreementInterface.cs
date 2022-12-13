using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface AgreementInterface
{
    Task<RequestAgreementDTO> RequestAgreementAsync(RequestAgreementDTO dto);
    Task<RespondAgreementDTO> RespondToAgreementAsync(RespondAgreementDTO dto);
    Task<AgreementListDTO> GetAllRequestsByHostDTOAsync(AgreementsByHostDTO dto);
    Task<AgreementDTO> GetAgreementByRefugeeEmail(string refugeeEmail);
}