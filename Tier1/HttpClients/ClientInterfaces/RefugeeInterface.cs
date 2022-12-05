using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface RefugeeInterface
{
    Task<RefugeeDTO> RegisterRefugee(RefugeeRegisterDTO dto);
    Task<RefugeeDTO> LoginRefugee(LoginDTO dto);
}