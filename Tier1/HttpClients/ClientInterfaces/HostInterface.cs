using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface HostInterface
{
    Task<HostDTO> RegisterHostAsync(HostRegisterDTO dto);
    Task<HostDTO> LoginHostAsync(LoginDTO dto);

    Task<HostDTO> GetHostByHousingId(long housingId);
}