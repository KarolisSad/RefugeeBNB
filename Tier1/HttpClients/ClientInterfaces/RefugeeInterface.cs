using Shared.Domain;

namespace HttpClients.ClientInterfaces;

public interface RefugeeInterface
{
    Task RegisterRefugee(Refugee refugee);
    Task<Refugee> LoginRefugee(string email, string password);
}