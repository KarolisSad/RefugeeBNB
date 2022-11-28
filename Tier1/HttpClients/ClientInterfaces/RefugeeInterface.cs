using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface RefugeeInterface
{
    Task RegisterRefugee(RefugeeRegisterDTO dto);
    Task<Refugee> LoginRefugee(LoginDTO dto);
}