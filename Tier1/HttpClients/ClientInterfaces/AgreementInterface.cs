﻿using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface AgreementInterface
{
    Task<RequestAgreementDTO> RequestAgreement(RequestAgreementDTO dto);
    Task<RespondAgreementDTO> RespondToAgreement(RespondAgreementDTO dto);
    Task<List<Agreement>> GetAllRequestsByHostDTO(AgreementsByHostDTO dto);
}