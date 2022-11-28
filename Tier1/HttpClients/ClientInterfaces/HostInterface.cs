using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface HostInterface
{
    Task RegisterHostAsync(HostRegisterDTO dto);
    Task<Host> LoginHostAsync(LoginDTO dto);
    Task<Housing> AddHousingAsync(HousingCreationDTO dto);
}